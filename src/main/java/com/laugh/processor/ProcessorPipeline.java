package com.laugh.processor;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

/**
 * @author yu.gao 2019-05-27 1:54 PM
 */
public class ProcessorPipeline {

    private final ProcessorContext head;
    private final ProcessorContext tail;
    private ProcessorContext now;
    private Map<Class<?>, String> nameCaches = new WeakHashMap<>();

    public ProcessorPipeline() {
        this.head = new ProcessorContext(this, null, null);
        this.tail = new ProcessorContext(this, null, null);
        head.next = tail;
        tail.prev = head;
    }

    public ProcessorPipeline addLast(String name, Processor processor) {
        ProcessorContext newCtx = new ProcessorContext(this, filterName(name, processor), processor);
        ProcessorContext prev = tail.prev;
        newCtx.prev = prev;
        newCtx.next = tail;
        prev.next = newCtx;
        tail.prev = newCtx;
        return this;
    }

    public ProcessorPipeline addLast(Processor processor) {
        addLast(null, processor);
        return this;
    }

    public ProcessorPipeline addFirst(String name, Processor processor) {
        ProcessorContext newCtx = new ProcessorContext(this, filterName(name, processor), processor);
        ProcessorContext next = head.next;
        newCtx.prev = head;
        newCtx.next = next;
        head.next = newCtx;
        next.prev = newCtx;
        return this;
    }


    public ProcessorPipeline addFirst(Processor processor) {
        addFirst(null, processor);
        return this;
    }

    public ProcessorPipeline addAfterNow(String name, Processor processor) {
        ProcessorContext newCtx = new ProcessorContext(this, filterName(name, processor), processor);
        newCtx.prev = now;
        newCtx.next = now.next;
        now.next.prev = newCtx;
        now.next = newCtx;
        return this;
    }

    public ProcessorPipeline addAfterNow(Processor processor) {
        addAfterNow(null, processor);
        return this;
    }

    public ProcessorPipeline addAfter(String baseName, String name, Processor processor) {
        ProcessorContext context = getContext(baseName);
        ProcessorContext newCtx = new ProcessorContext(this, filterName(name, processor), processor);
        newCtx.prev = context;
        newCtx.next = context.next;
        context.next.prev = newCtx;
        context.next = newCtx;
        return this;
    }

    private String filterName(String name, Processor processor) {
        if(name == null) {
            return generateName(processor);
        }
        checkDuplicateName(name);
        return name;
    }

    private String generateName(Processor processor) {
        Class<?> processorClass = processor.getClass();
        String name = nameCaches.get(processorClass);
        if(name == null) {
            name = simpleClassName(processorClass);
            nameCaches.put(processorClass, name);
        }
        if (context0(name) != null) {
            String baseName = name.substring(0, name.length() - 1); // Strip the trailing '0'.
            for (int i = 1;; i ++) {
                String newName = baseName + i;
                if (context0(newName) == null) {
                    name = newName;
                    break;
                }
            }
        }
        return name;
    }

    private String simpleClassName(Class<?> clazz) {
        String className = checkNotNull(clazz, "clazz").getName();
        final int lastDotIdx = className.lastIndexOf('.');
        if (lastDotIdx > -1) {
            return className.substring(lastDotIdx + 1);
        }
        return className;
    }

    private  <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }

    private ProcessorContext context0(String name) {
        ProcessorContext context = head.next;
        while (context != tail) {
            if (context.name.equals(name)) {
                return context;
            }
            context = context.next;
        }
        return null;
    }

    private ProcessorContext getContext(String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        ProcessorContext context = context0(name);
        if (context == null) {
            throw new NoSuchElementException(name);
        } else {
            return context;
        }
    }

    private void checkDuplicateName(String name) {
        if (context0(name) != null) {
            throw new IllegalArgumentException("Duplicate processor name: " + name);
        }
    }

    public void process(Context context) {
        ProcessorContext now = head.next;
        while (now != tail) {
            if(now.processor != null) {
                this.now = now;
                now.processor.process(context);
            }
            now = now.next;
        }
    }

    public class ProcessorContext {
        private final ProcessorPipeline pipeline;
        private final Processor processor;
        private final String name;
        ProcessorContext prev;
        ProcessorContext next;

        ProcessorContext(ProcessorPipeline pipeline, String name, Processor processor) {
            this.pipeline = pipeline;
            this.processor = processor;
            this.name = name;
        }

        public Processor getProcessor() {
            return processor;
        }
    }

    public static void main(String[] args) {
        ProcessorPipeline pipeline = new ProcessorPipeline();
        DefaultContext defaultContext = DefaultContext.build(1);

        defaultContext.setPipeline(pipeline);

        pipeline.addLast(context -> System.out.println(1));
        pipeline.addLast(context -> System.out.println(2));
        pipeline.addLast("#tmp1",context -> {
            if(context.getTag() == 1) {
                context.getPipeline().addAfterNow(context1 -> System.out.println(2.5));
            } else {
                context.getPipeline().addAfterNow("#tmp2", context1 -> System.out.println(2.6));
                context.getPipeline().addAfter("#tmp2", "#tmp3", context1 -> System.out.println(2.7));
            }
        });
        pipeline.addLast(context -> System.out.println(3));
        pipeline.addLast(context -> System.out.println(4));
        pipeline.process(defaultContext);
    }
}

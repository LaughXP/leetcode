package com.laugh.processor;

/**
 * @author yu.gao 2019-02-19 10:52 AM
 */
public class DefaultContext implements Context {

    private Integer tag;

    private ProcessorPipeline pipeline;

    public DefaultContext(Integer tag) {
        this.tag = tag;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public ProcessorPipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(ProcessorPipeline pipeline) {
        this.pipeline = pipeline;
    }

    public static DefaultContext build(Integer tag) {
        return new DefaultContext(tag);
    }
}

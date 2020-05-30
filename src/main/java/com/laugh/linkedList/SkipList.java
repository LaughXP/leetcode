package com.laugh.linkedList;

import java.util.Random;

/**
 * @author yu.gao 2019-12-11 3:01 PM
 */
public class SkipList {

    private static final int MAX_LEVEL = 32;

    private static final double PROB = 0.5;

    private int level;

    private Random random = new Random();

    private final Node HEAD = new Node(Node.HEAD_KEY, 0, MAX_LEVEL);
    private final Node TAIL = new Node(Node.TAIL_KEY, 0, MAX_LEVEL);

    public class Node {
        public static final int HEAD_KEY = Integer.MIN_VALUE;
        public static final int TAIL_KEY = Integer.MAX_VALUE;

        public int k;

        public Object v;

        public Node[] right;

        public Node[] left;

        public Node(int k, Object v, int level) {
            this.k = k;
            this.v = v;
            this.right = new Node[level];
            this.left = new Node[level];
        }

        public boolean eq(Node node) {
            return this == node || (this.k == node.k && this.v == node.v);
        }
    }

    public SkipList() {
        for(int i = 0; i < MAX_LEVEL; i++) {
            HEAD.right[i] = TAIL;
            TAIL.left[i] = HEAD;
        }
    }

    private Node findClosest(int k, Node[] update) {
        Node n = HEAD;
        for (int i = level - 1; i >=0; i--) {
            while (i < n.right.length && n.right[i].k != Node.TAIL_KEY && n.right[i].k <= k) {
                n = n.right[i];
            }
            if(update != null) {
                update[i] = n;
            }
        }
        return n;
    }

    public Node search(int k) {
        Node n = findClosest(k, null);
        if(k == n.k) {
            return n;
        }
        return null;
    }

    public void put(int k, Object v) {
        Node[] update = new Node[MAX_LEVEL];
        Node p = findClosest(k, update);
        if(p.k == k) {
            p.v = v;
            return;
        }
        int newLevel = randomLevel();
        Node q = new Node(k, v, newLevel);
        if(newLevel > level) {
            for(int i = level; i < newLevel; i++) {
                update[i] = HEAD;
            }
            level = newLevel;
        }
        for(int i = newLevel - 1; i >= 0; i--) {
            q.right[i] = update[i].right[i];
            update[i].right[i] = q;

            q.left[i] = update[i];
            q.right[i].left[i] = q;
        }
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < PROB) {
            level++;
        }
        return Math.min(level, MAX_LEVEL);
    }

    public void remove(int k) {
        Node n = search(k);
        if(n == null) {
            return;
        }
        for(int i = 0; i < n.right.length; i++) {
            n.right[i].left[i] = n.left[i];
            n.left[i].right[i] = n.right[i];
            n.left[i] = null;
            n.right[i] = null;
        }
        while (level > 0 && HEAD.right[level-1] == TAIL) {
            level--;
        }
    }

    public void show() {
        for(int i = level - 1; i >=0; i--) {
            String s = "level " + i + ":";
            Node n = HEAD;
            while (n.k != Node.TAIL_KEY) {
                if(n.k == Node.HEAD_KEY) {
                    s += "HEAD ";
                } else {
                    s += n.k + " ";
                }
                n = n.right[i];
            }
            s += "TAIL";
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.put(1,1);
        skipList.put(2,2);
        skipList.put(3,4);
        System.out.println(skipList.search(3).v);
        skipList.show();

        skipList.remove(2);
        System.out.println("REMOVE");
        skipList.show();
    }
}

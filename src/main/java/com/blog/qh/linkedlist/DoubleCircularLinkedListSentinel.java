package com.blog.qh.linkedlist;


/**
 * 带哨兵的双向环形链表
 */
public class DoubleCircularLinkedListSentinel {

    private Node sentinel = new Node(null,-1000,null);

    public DoubleCircularLinkedListSentinel() {
        this.sentinel.pre = this.sentinel;
        this.sentinel.next = this.sentinel;
    }


    /**
     * 添加第一个元素
     */

    public void addLast(int val) {

        if(this.sentinel.next == this.sentinel) {
            Node node = new Node(sentinel, val, sentinel);
            this.sentinel.next = node;
            this.sentinel.pre = node;
        }

    }


    /**
     * 删除最后一个元素
     */


    /**
     * 根据索引删除元素
     */


    /**
     * 根据索引查找元素
     */


    /**
     * 根据索引删除元素
     */


    public static void main(String[] args) {


        DoubleCircularLinkedListSentinel doubleCircularLinkedListSentinel = new DoubleCircularLinkedListSentinel();

        doubleCircularLinkedListSentinel.addLast(1);


        System.out.println("sxxx");

    }







    class Node {
        private Node pre;
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}

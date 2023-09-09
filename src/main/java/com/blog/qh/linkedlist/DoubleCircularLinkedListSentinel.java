package com.blog.qh.linkedlist;


import java.util.Objects;

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
        Node next = sentinel.next;
        Node pre = sentinel;
        Node node = new Node(pre, val, next);
        next.pre = node;
        pre.next = node;
    }

    /**
     * 添加在最后一个元素
     */

    public void addFirst(int val) {
//      最后一个节点
        Node lastNode = sentinel.pre;
//      添加的节点
        Node node = new Node(lastNode,val,sentinel);
//      把原本最后一个节点的下一个指向添加的节点
        lastNode.next = node;
//      把头节点的上一个指向添加的节点
        sentinel.pre = node;
    }


    /**
     * 根据索引添加节点
     * @param index
     * @param val
     */
    public void insertByIndex(int index,int val) {
//      添加在该节点之前
        Node node = findNode(index);
//       不存在的节点，超出索引
        if(Objects.isNull(node)) {
            throw new IllegalArgumentException("index");
        }
//      添加的节点
        Node addNode = new Node(node.pre, val, node.next);
        node.pre.next = addNode;
        node.pre = addNode;



    }



    /**
     * 删除最后一个元素
     */
    public void remove() {
        Node sentinel = this.sentinel;
//        待删除节点
        Node removeNode = sentinel.pre;
//        待删除节点的上一个节点，并把他的next节点指向头节点
        removeNode.pre.next = sentinel;
//        把头节点的上一个指向待删除的上一个节点
        sentinel.pre = removeNode.pre;
    }


    /**
     * 根据索引删除元素
     */
    public void removeByIndex(int index) {
        Node node = findNode(index);
        if(Objects.isNull(node)) {
            throw new IllegalArgumentException("index");
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }




    /**
     * 根据索引查找元素
     */
    public Node findNode(int index) {
        int i = 0;
        for(Node temp1 = sentinel; temp1.next != sentinel;temp1 = temp1.next,i++) {
            if(i == index) {
                return temp1.next;
            }
        }
        return null;
    }


    /**
     * 根据值查找元素
     */

    public Node findByValue(int val) {
        Node temp = sentinel;
        while (temp.next != sentinel) {
            if(temp.value == val) {
                return temp.next;
            }
            temp = temp.next;
        }
        return null;
    }


    public static void main(String[] args) {


        DoubleCircularLinkedListSentinel doubleCircularLinkedListSentinel = new DoubleCircularLinkedListSentinel();

        doubleCircularLinkedListSentinel.addLast(1);
        doubleCircularLinkedListSentinel.addLast(2);
        doubleCircularLinkedListSentinel.remove();
        doubleCircularLinkedListSentinel.addFirst(10);
        System.out.println(doubleCircularLinkedListSentinel.findNode(0).value);
        doubleCircularLinkedListSentinel.removeByIndex(1);
        System.out.println(doubleCircularLinkedListSentinel.findByValue(10).value);
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

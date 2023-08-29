package com.blog.qh.linkedlist;


import javax.xml.bind.Element;
import java.util.Objects;

/**
 * 带哨兵双链表
 */
public class DoubleLinkedListSentinel {
    private final Node head;
    private final Node tail;
    public DoubleLinkedListSentinel() {
        this.head = new Node(null,-100,null);
        this.tail = new Node(null,-200,null);
        head.next = tail;
        tail.pre = head;
    }

    public void addFirst(int val) {
        if(head.next == tail) {
            Node next = head.next;
            head.next = new Node(head,val,tail);
            next.pre = head.next;
            return;
        }

        Node next = head.next;
        Node element = new Node(head, val, next);
        head.next = element;
        next.pre = element;

    }

    public void addLast(int val) {
        if(head.next == tail) {
            addFirst(val);
        }
        Node temp = head;
        while (temp != tail) {
            temp = temp.next;
        }
        Node element = new Node(temp.pre,val,temp);
        temp.pre.next = element;
        temp.pre = element;
    }

    public Node findNode(int index) {
        int i = -1;
        if(i == index) {
            return null;
        }
        for(Node temp = head;temp!=tail;temp = temp.next,i++) {
            if(i == index) {
                return temp;
            }
        }
        return null;
    }

    public void insert(int index,int val) {
        if(index < 0) {
            throw new IllegalArgumentException("index");
        }
        Node node = findNode(index);
        if(node == null) {
            throw new IllegalArgumentException("index");
        }
        Node pre = node.pre;
        Node element = new Node(pre, val, node);
        pre.next = element;
        node.pre = element;
    }

    public void remove(int index) {
        Node node = findNode(index);

        if(node == null) {
            throw new IllegalArgumentException("index");
        }

        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }


    public void loop() {
        for(Node temp = head.next; temp != tail;temp = temp.next) {
            System.out.println(temp.value);
        }
    }

//  递归循环
    public void loop2() {
        recursion(head.next);
    }

    public void recursion(Node node) {
        if(node == tail) {
            return;
        }
        System.out.println(node.value);
        recursion(node.next);
    }



    public static void main(String[] args) {


        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addFirst(1);
        doubleLinkedListSentinel.addFirst(2);
        doubleLinkedListSentinel.addFirst(3);
        doubleLinkedListSentinel.addLast(4);

        doubleLinkedListSentinel.insert(0,100);
        doubleLinkedListSentinel.insert(4,200);



////        doubleLinkedListSentinel.remove(0);
//        System.out.println("删除之后");
//        doubleLinkedListSentinel.loop();
//        System.out.println("递归循环：");
//        doubleLinkedListSentinel.loop2();

        System.out.println("删除之前");
        doubleLinkedListSentinel.loop();
        System.out.println("删除之后");
        doubleLinkedListSentinel.remove(5);
        doubleLinkedListSentinel.loop2();
    }




    static class Node {
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pre=" + pre +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "DoubleLinkedListSentinel{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }


}



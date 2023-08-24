package com.blog.qh.linkedlist;

import java.util.Objects;
import java.util.function.Consumer;

public class SingleLinkedList {
    private Node head;

    class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    // 链表头插入
    public void addFirst(Node element) {
        if(head != null) {
            Node p = head;
            head = element;
            head.next = p;
            return;
        }
        head = element;
    }


    // 查找最后一个链表节点
    public Node findLast() {
        if (head == null) {
            return null;
        }

        Node p  = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }
    // 链表尾插入
    public void addLast(Node element) {
        Node last = findLast();
        if (last != null) {
            last.next = element;
            return;
        }
        addFirst(element);
    }

    // 遍历链表
    public void loop(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }


    // 根据索引节点
    public Node findNode(int index) {
        if (Objects.isNull(head)) {
            return null;
        }
        int i = 0;
        for(Node temp = head; temp != null;temp = temp.next,i++) {
            if (i == index) {
                return temp;
            }
        }
        return null;
    }

    //   根据索引获取节点值
    public int get(int index) {
        Node node = findNode(index);
        if (Objects.isNull(node)) {
            throw new IllegalArgumentException(String.format("index [%d]",index));
        }
        return node.value;
    }

    //  根据索引插入元素
    public int insertbyIndex(int index, Node element) {
        Node node1 = findNode(index -1);
        if (node1 != null) {
            Node next = node1.next;
            node1.next = element;
            element.next = next;
            return element.value;
        }
        addFirst(element);
        return element.value;
    }



    public static void main(String[] args) {
        Node node1 = new SingleLinkedList().new Node(1);
        Node node2 = new SingleLinkedList().new Node(2);
        Node node3 = new SingleLinkedList().new Node(10);
        Node node4 = new SingleLinkedList().new Node(100);
        SingleLinkedList demo = new SingleLinkedList();
        demo.addFirst(node1);
        demo.addFirst(node2);
        demo.addFirst(node3);
        demo.addLast(node4);
        demo.loop(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println(demo);

        System.out.println(demo.findNode(3));
        System.out.println(demo.get(3));

        Node node5 = new SingleLinkedList().new Node(34);
        demo.insertbyIndex(0,node5);
        System.out.println(demo);
    }

    @Override
    public String toString() {
        return "Demo{" +
                "head=" + head +
                '}';
    }
}

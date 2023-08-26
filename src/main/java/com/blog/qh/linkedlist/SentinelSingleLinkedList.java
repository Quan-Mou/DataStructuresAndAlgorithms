package com.blog.qh.linkedlist;


import com.sun.xml.internal.bind.v2.TODO;

/**
 * 带哨兵单链表
 */
public class SentinelSingleLinkedList {

    private Node head = new Node(-1,null);

     static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
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
//      非空链表
        if(head.next != null) {
            Node temp = head.next;
            head.next = element;
            element.next = temp;
            return;
        }
//      空链表
        head.next = element;
    }


    // 查找最后一个链表节点
    public Node findLast() {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    // 链表尾插入
    public void addLast(Node element) {
        Node last = findLast();
        last.next = element;
    }

    // 遍历链表
    public void loop() {





    }


    // 根据索引节点
    public Node findNode(int index) {
        if (index < 0) {
            return null;
        }
        int i = -1;
        Node temp;
        for(temp = head;temp != null;) {
            if(i == index) {
                return temp;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }


    //   根据索引获取节点值
    public int get(int index) {
        Node node = findNode(index);
        if(node != null) {
            return node.value;
        }
        throw new IllegalArgumentException("index");
    }


    //  根据索引插入元素,返回插入的元素
    public int insertByIndex(int index, Node element) {

//      运行到这代表在第一个元素，索引为0
        if(index == 0) {
            if(head.next != null) {
                Node next = head.next;
                head.next = element;
                element.next = next;
                return element.value;
            }
//      空链表
            addFirst(element);
            return element.value;
        }

        try {
            Node pre = findNode(index-1);
            Node next = pre.next;
            pre.next = element;
            element.next =next;
        } catch (Exception e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
        return element.value;
    }



    // 通过索引删除链表元素
    public int remove(int index) {
        Node node = findNode(index);
        if(node.next == null && head.next == null) {
            throw new IllegalArgumentException("index");
        }
        if(node.next == null) {
            Node lastNode = findNode(index-1);
            lastNode.next = null;
            return node.value;
        }

        Node pre = findNode(index - 1);
        if(pre == null) {
            head.next= node.next;
            return node.value;
        }
        pre.next = node.next;
        return node.value;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        SentinelSingleLinkedList sentinelSingleLinkedList = new SentinelSingleLinkedList();
        sentinelSingleLinkedList.addFirst(node1);
        sentinelSingleLinkedList.addFirst(node2);
        sentinelSingleLinkedList.addFirst(node3);
        sentinelSingleLinkedList.addFirst(node4);
        Node node = sentinelSingleLinkedList.findNode(0);
        System.out.println(node);
        sentinelSingleLinkedList.addLast(node5);
        System.out.println(sentinelSingleLinkedList.findLast());
        System.out.println(sentinelSingleLinkedList.get(4));
        Node node6 = new Node(6);
        sentinelSingleLinkedList.insertByIndex(5,node6);
        System.out.println(sentinelSingleLinkedList);

        sentinelSingleLinkedList.remove(5);
        System.out.println(sentinelSingleLinkedList);

    }

    @Override
    public String toString() {
        return "SentinelSingleLinkedList{" +
                "head=" + head +
                '}';
    }
}

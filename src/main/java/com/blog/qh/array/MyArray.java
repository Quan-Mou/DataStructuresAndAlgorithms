package com.blog.qh.array;

import java.util.Arrays;

public class MyArray {

    private int size; // 实际存储的大小
    private int capacity = 10; // 容量大小

    private int[] arr = new int[capacity];


    /**
     * 添加到最后一个元素
     * @param element
     */
    public void addLast(int element) {
        incrementCapaticy();
        arr[size++] = element;

    }

    public void add(int index,int element) {
        if(index >= 0 && index < size) {
            incrementCapaticy();
            for (int i = size-1; i >= index ; i--) {
                arr[i+1] = arr[i];
            }
            arr[index] = element;
            size++;
        } else {
            throw new RuntimeException("超出size大小");
        }
    }



    public int length() {
        return size;
    }

    public void incrementCapaticy() {
        if (size == capacity) {
            capacity = capacity << 1;  // 容量*1倍
            arr = Arrays.copyOf(arr, capacity);
            return;
        }
    }

    public int remove(int index) {
        int val = 0;
        if(index < size) {
            int i = index;
            val = arr[index];
            while (i<size) {
                arr[i]= arr[i+1];
                i++;
            }
        }
        return val;
    }



    public int get(int index) {
        if (index < size) {
            return arr[index];
        }
        throw new RuntimeException("超出size大小");
    }
    @Override
    public String toString() {
        return "Demo{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        MyArray demo = new MyArray();
        demo.addLast(1);
        demo.addLast(2);
        demo.addLast(3);
        demo.addLast(4);
        demo.addLast(5);

        System.out.println(demo.remove(1));
        System.out.println(Arrays.toString(demo.arr));
    }


}

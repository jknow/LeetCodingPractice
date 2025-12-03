package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sorts sorts = new Sorts();

        // int[] arr = {2, 3, 4, 4, 4, 6, 6, 7, 8, 8, 9, 9};

        int[] arr = {6,4,7,8,3,6,8,9,2,4,9,4};
        //sorts.quickSort(arr, 0, arr.length - 1);
        sorts.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2, 3, 4, 4, 4, 6, 6, 8, 7, 8, 9, 9};
        sorts.quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {9, 9, 8, 8, 7, 6, 6, 4, 4, 4, 3, 2};
        sorts.quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));

        QueueImpl<Integer> q = new QueueImpl<>(2);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println("New Queue");

        q = new QueueImpl<>(2);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.dequeue()); // 4
        System.out.println(q.dequeue()); // 5
        System.out.println(q.dequeue()); // 6
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        System.out.println(q.dequeue()); // 7
        System.out.println(q.dequeue()); // 8
    }
}
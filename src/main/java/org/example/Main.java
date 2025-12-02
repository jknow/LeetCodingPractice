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

        HashTableImpl<Integer, Integer> hTable = new HashTableImpl<>(5);
        hTable.add(1,1);
        hTable.add(2,2);
        hTable.add(3,3);
        hTable.add(4,4);
        hTable.add(5,5);
        hTable.add(6,6);
        System.out.println(hTable.get(6));
        hTable.remove(1);
        System.out.println(hTable.get(6));
    }
}
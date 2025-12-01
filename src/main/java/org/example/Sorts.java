package org.example;

public class Sorts {

    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int holder = arr[i];
            int j = i;

            while (j > 0 && holder < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = holder;
        }
    }

    // Quicksort
    public void quickSort(int[] arr, int leftMostIndex, int rightMostIndex) {
        if (leftMostIndex < rightMostIndex) {
            int pvtIndex = partition(arr, leftMostIndex, rightMostIndex);
            quickSort(arr, leftMostIndex, pvtIndex-1);
            quickSort(arr, pvtIndex+1, rightMostIndex);
        }
    }

    private int partition(int[] arr, int leftMostIndex, int rightMostIndex) {
        int pvtVal = arr[rightMostIndex];

        int i = leftMostIndex - 1;
        for (int j = leftMostIndex; j < rightMostIndex; j++) {
            if (arr[j] < pvtVal) {
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[++i];
        arr[i] = arr[rightMostIndex];
        arr[rightMostIndex] = temp;

        return i;
    }
}

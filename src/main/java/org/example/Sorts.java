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
            int pvtIndex = qsPartition(arr, leftMostIndex, rightMostIndex);
            quickSort(arr, leftMostIndex, pvtIndex-1);
            quickSort(arr, pvtIndex+1, rightMostIndex);
        }
    }

    private int qsPartition(int[] arr, int leftMostIndex, int rightMostIndex) {
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

    // Merge Sort
    public void mergeSort(int[] arr, int leftMostIndex, int rightMostIndex) {
        if (leftMostIndex < rightMostIndex) {
            int mid = leftMostIndex + (rightMostIndex - leftMostIndex) / 2;

            mergeSort(arr, leftMostIndex, mid);
            mergeSort(arr, mid + 1, rightMostIndex);

            merge(arr, leftMostIndex, mid, rightMostIndex);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {

        // Initialization of copied temp arrays
        // Find sizes of the array to be merged
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // Create temp arrays
        int[] leftTemp = new int[size1];
        int[] rightTemp = new int[size2];

        // Copy data to temp arrays
        for (int i = 0; i < size1; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightTemp[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merge subarray array
        int k = left;

        // Merge the temp arrays into the original array
        while (i < size1 && j < size2) {
            if (leftTemp[i] <= rightTemp[j]) {
                arr[k++] = leftTemp[i++];
            } else {
                arr[k++] = rightTemp[j++];
            }
        }

        // Copy any remaining elements of leftTemp
        while (i < size1) {
            arr[k++] = leftTemp[i++];
        }

        // Copy any remaining elements of rightTemp
        while (j < size2) {
            arr[k++] = rightTemp[j++];
        }
    }
}

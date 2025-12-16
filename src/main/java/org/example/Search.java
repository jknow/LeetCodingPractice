package org.example;

public class Search {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int half = ((right - left) / 2) + left;
            if (nums[half] == target) {
                return half;
            } else if (nums[half] < target) {
                left = half + 1;
            } else if (nums[half] > target) {
                right = half - 1;
            }
        }
        return -1;
    }
}

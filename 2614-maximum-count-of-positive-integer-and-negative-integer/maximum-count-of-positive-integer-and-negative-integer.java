class Solution {
    public int maximumCount(int[] nums) {
        int neg = findFirstNonNegativeIndex(nums); // Count of negative numbers
        int pos = nums.length - findFirstPositiveIndex(nums); // Count of positive numbers
        return Math.max(neg, pos);
    }

    // Finds the first index where nums[i] >= 0 (first non-negative number)
    private int findFirstNonNegativeIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // Number of negative elements
    }

    // Finds the first index where nums[i] > 0 (first positive number)
    private int findFirstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // Number of negative and zero elements
    }
}

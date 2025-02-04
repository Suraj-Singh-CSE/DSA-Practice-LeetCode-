class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize max sum with the first element
        int currentSum = nums[0]; // Track current subarray sum

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Continue the ascending subarray
                currentSum += nums[i];
            } else {
                // Start a new subarray
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum); // Update max sum
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {10, 20, 30, 5, 10, 50};
        int[] nums2 = {10, 20, 30, 40, 50};
        int[] nums3 = {12, 17, 15, 13, 10, 11, 12};
        
        System.out.println(sol.maxAscendingSum(nums1)); // Output: 65
        System.out.println(sol.maxAscendingSum(nums2)); // Output: 150
        System.out.println(sol.maxAscendingSum(nums3)); // Output: 33
    }
}

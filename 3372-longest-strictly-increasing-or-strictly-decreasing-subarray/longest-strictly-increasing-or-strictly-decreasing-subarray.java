class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1; // If only one element, return 1
        
        int maxLen = 1; // At least one element is always present
        int inc = 1, dec = 1; // Initialize increasing and decreasing counters
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += 1; // Extend increasing subarray
                dec = 1;  // Reset decreasing subarray
            } else if (nums[i] < nums[i - 1]) {
                dec += 1; // Extend decreasing subarray
                inc = 1;  // Reset increasing subarray
            } else {
                inc = 1; // Reset both when equal
                dec = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc, dec)); // Update max length
        }
        
        return maxLen;
    }
}

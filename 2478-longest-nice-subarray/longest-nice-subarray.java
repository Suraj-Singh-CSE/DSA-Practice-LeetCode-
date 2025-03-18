class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, used_bits = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // Ensure all elements in the window satisfy the condition
            while ((used_bits & nums[right]) != 0) {
                used_bits ^= nums[left]; // Remove nums[left] from the window
                left++;
            }
            used_bits |= nums[right]; // Add nums[right] to the window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

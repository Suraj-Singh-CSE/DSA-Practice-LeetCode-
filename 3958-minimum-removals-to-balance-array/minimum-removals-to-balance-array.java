
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        
        // Sort the array
        Arrays.sort(nums);

        int left = 0;
        int maxLen = 0;

        // Sliding window
        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Minimum removals
        return n - maxLen;
    }
}

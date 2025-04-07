class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, it can't be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // Zero sum is always possible

        // Process each number in nums
        for (int num : nums) {
            // Traverse dp array from right to left
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}

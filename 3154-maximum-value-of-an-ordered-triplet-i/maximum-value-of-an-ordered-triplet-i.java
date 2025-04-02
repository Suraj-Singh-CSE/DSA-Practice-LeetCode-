class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;  // Base case (though constraints ensure n ≥ 3)

        // Step 1: Compute prefixMax[i] (max element before i)
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Step 2: Compute suffixMax[k] (max element after k)
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            suffixMax[k] = Math.max(suffixMax[k + 1], nums[k]);
        }

        // Step 3: Compute max triplet value
        long maxVal = 0;
        for (int j = 1; j < n - 1; j++) {
            long tripletValue = (long) (prefixMax[j - 1] - nums[j]) * suffixMax[j + 1];
            maxVal = Math.max(maxVal, tripletValue);
        }

        return maxVal;
    }
}

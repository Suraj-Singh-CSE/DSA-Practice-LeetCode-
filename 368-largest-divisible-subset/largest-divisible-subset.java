
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums); // Step 1: Sort the array
        int[] dp = new int[n];        // dp[i] = size of largest divisible subset ending at nums[i]
        int[] parent = new int[n];    // parent[i] = previous index in the subset chain

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxSize = 1;
        int maxIndex = 0;

        // Step 2: Fill dp[] and parent[] arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            // Update maxSize and maxIndex if needed
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 3: Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        Collections.reverse(result); // To get the subset in increasing order
        return result;
    }
}

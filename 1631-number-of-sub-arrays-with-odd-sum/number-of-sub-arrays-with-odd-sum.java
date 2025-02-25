class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1;  // evenCount starts at 1 to handle the prefix sum = 0 case
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;  // Increment count of even prefix sums
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;  // Increment count of odd prefix sums
            }
        }

        return result;
    }
}

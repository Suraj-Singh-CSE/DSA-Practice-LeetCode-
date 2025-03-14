class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = (int) 1e7, res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(candies, k, mid)) {
                res = mid; // Update result and try for a larger value
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private boolean canDistribute(int[] candies, long k, int x) {
        long count = 0;
        for (int candy : candies) {
            count += candy / x; // Number of children that can get x candies
            if (count >= k) return true; // Early stopping
        }
        return count >= k;
    }
}

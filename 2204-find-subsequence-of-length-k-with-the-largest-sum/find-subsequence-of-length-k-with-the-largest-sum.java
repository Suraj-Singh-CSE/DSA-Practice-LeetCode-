
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        
        // Store (value, index) pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Sort by value descending
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        // Pick top k elements
        List<int[]> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(pairs[i]);
        }
        
        // Sort back by index to maintain original order
        topK.sort(Comparator.comparingInt(a -> a[1]));
        
        // Build result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i)[0];
        }
        
        return res;
    }
}

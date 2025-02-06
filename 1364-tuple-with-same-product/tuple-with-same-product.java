import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int count = 0;
        
        // Step 1: Compute all possible products and store frequency in HashMap
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }
        
        // Step 2: Compute valid tuples using combination formula
        for (int freq : productMap.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8; // Each valid tuple has 8 permutations
            }
        }
        
        return count;
    }
}

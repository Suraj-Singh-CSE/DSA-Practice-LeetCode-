class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;
        int whiteCount = 0;
        
        // Count 'W' in the first window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        minOperations = whiteCount;  // Initial minimum

        // Sliding window approach
        for (int i = k; i < blocks.length(); i++) {
            // Remove leftmost character's effect
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add new character's effect
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            // Update minimum
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }
}

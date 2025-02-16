import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;  // Total sequence length
        int[] result = new int[len];  // The sequence to be filled
        boolean[] used = new boolean[n + 1];  // Track used numbers

        backtrack(result, used, n, 0);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int n, int index) {
        if (index == result.length) return true;  // Successfully filled the sequence

        if (result[index] != 0) return backtrack(result, used, n, index + 1); // Skip filled positions

        // Try placing numbers from n down to 1 (lexicographically largest first)
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue; // Already placed

            int secondPos = index + num;  // Second position for num > 1

            if (num == 1 || (secondPos < result.length && result[secondPos] == 0)) {
                // Place the number in both positions (if num > 1)
                result[index] = num;
                if (num > 1) result[secondPos] = num;
                used[num] = true;

                // Recurse to the next index
                if (backtrack(result, used, n, index + 1)) return true;

                // Backtrack if the placement didn't work
                result[index] = 0;
                if (num > 1) result[secondPos] = 0;
                used[num] = false;
            }
        }
        return false;  // No valid placement found
    }
}

class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false; // Found a pair with the same parity
            }
        }
        return true; // All adjacent pairs have different parity
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isArraySpecial(new int[]{1})); // true
        System.out.println(solution.isArraySpecial(new int[]{2, 1, 4})); // true
        System.out.println(solution.isArraySpecial(new int[]{4, 3, 1, 6})); // false
    }
}

class Solution {
    public boolean check(int[] nums) {
        int count = 0; // Count of drop points
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) { // Compare with next element (circular check)
                count++;
            }
            if (count > 1) return false; // More than one drop point → Not rotated sorted
        }

        return true; // Valid rotated sorted array
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(new int[]{3, 4, 5, 1, 2})); // true
        System.out.println(solution.check(new int[]{2, 1, 3, 4})); // false
        System.out.println(solution.check(new int[]{1, 2, 3})); // true
        System.out.println(solution.check(new int[]{1, 1, 1})); // true
    }
}

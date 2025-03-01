class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Shift non-zero elements to the front
        int index = 0; // Pointer for placing non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Fill remaining positions with 0
        while (index < n) {
            nums[index++] = 0;
        }

        return nums;
    }
}

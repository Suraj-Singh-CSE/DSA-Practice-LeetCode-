class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Check if we can flip the next three elements
                if (i + 2 < n) {
                    flip(nums, i);
                    operations++;
                } else {
                    return -1; // Impossible to make all elements 1
                }
            }
        }
        return operations;
    }

    private void flip(int[] nums, int start) {
        for (int i = start; i < start + 3; i++) {
            nums[i] = 1 - nums[i]; // Flip 0 to 1 and 1 to 0
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0,1,1,1,0,0};
        int[] nums2 = {0,1,1,1};

        System.out.println(solution.minOperations(nums1)); // Output: 3
        System.out.println(solution.minOperations(nums2)); // Output: -1
    }
}

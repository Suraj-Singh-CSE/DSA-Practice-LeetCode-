
class Solution {
    public int partitionArray(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Initialize the counter for subsequences
        int count = 1; // At least one subsequence
        int start = nums[0]; // Start of the first subsequence

        // Step 3: Traverse the sorted array
        for (int i = 1; i < nums.length; i++) {
            // If difference exceeds k, start a new subsequence
            if (nums[i] - start > k) {
                count++;
                start = nums[i]; // Update start for the new subsequence
            }
        }

        return count;
    }
}

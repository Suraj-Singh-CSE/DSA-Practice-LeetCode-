class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // Handle the edge case where the input array is empty
        if (nums.length == 0) {
            return 0;
        }
        
        int maxLength = 1;  // Minimum length of a subsequence is 1 (the number itself)
        int currentLength = 1;  // Length of the current increasing subsequence

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // If the current element is greater than the previous one, it's part of an increasing subsequence
                currentLength++;
            } else {
                // Otherwise, reset the current subsequence length
                currentLength = 1;
            }
            
            // Update the maximum length encountered so far
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;  // Return the maximum length of the continuous increasing subsequence
    }
}

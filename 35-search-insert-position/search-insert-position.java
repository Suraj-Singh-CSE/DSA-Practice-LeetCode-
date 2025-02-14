class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid to avoid overflow
            
            if (nums[mid] == target) {
                return mid; // If target is found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1; // If target is greater, search the right half
            } else {
                right = mid - 1; // If target is smaller, search the left half
            }
        }
        
        return left; // If target is not found, return the position to insert
    }
}

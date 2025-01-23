public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store the index of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If we have already seen this element
            if (map.containsKey(nums[i])) {
                // Check if the difference between indices is less than or equal to k
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // Update the element's index in the map
            map.put(nums[i], i);
        }
        
        // If no pair satisfies the condition
        return false;
    }
}
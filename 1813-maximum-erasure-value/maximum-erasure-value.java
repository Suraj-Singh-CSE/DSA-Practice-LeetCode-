import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxScore = 0, currentSum = 0;

        while (right < nums.length) {
            // If we see a duplicate, move left pointer until it's removed
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            // Add current number to set and sum
            seen.add(nums[right]);
            currentSum += nums[right];
            maxScore = Math.max(maxScore, currentSum);
            right++;
        }

        return maxScore;
    }
}

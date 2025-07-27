class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            // Skip if nums[i] is equal to the previous one (part of plateau)
            if (nums[i] == nums[i - 1]) continue;

            // Find left closest non-equal
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }

            // Find right closest non-equal
            int right = i + 1;
            while (right < nums.length && nums[right] == nums[i]) {
                right++;
            }

            if (left >= 0 && right < nums.length) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++; // hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++; // valley
                }
            }
        }

        return count;
    }
}

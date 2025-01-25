class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums.length == 0) {
            return ranges;  // Return an empty list if the array is empty
        }

        int start = nums[0];  // Initialize the start of the current range

        for (int i = 1; i <= nums.length; i++) {
            // If the current number is not consecutive or we've reached the end of the array
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    // If start and end are the same, it's a single number
                    ranges.add(String.valueOf(start));
                } else {
                    // Otherwise, it's a range from start to the previous number
                    ranges.add(start + "->" + nums[i - 1]);
                }

                // Start a new range if there are more numbers
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return ranges;
    }
}

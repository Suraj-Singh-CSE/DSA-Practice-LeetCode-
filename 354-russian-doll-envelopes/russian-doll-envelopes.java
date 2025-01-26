
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; 
            }
            return a[0] - b[0]; 
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }
    private int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int idx = Arrays.binarySearch(lis, 0, length, num);
            if (idx < 0) {
                idx = -(idx + 1); 
            }
            lis[idx] = num;
            if (idx == length) {
                length++;
            }
        }

        return length;
    }
}

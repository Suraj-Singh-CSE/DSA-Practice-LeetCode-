class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int[] freq = new int[nums.length];
        int k = 0;
        for(int num : nums) {
            freq[num]++;
            if(freq[num] == 2) {
              ans[k] = num;
              k++;
            }
        }
        return ans;
    }
}
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> resultSet = new HashSet<>();
        int n = nums.length;

        // Loop through the array to find all indices where nums[j] == key
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                // For each key index, add all i such that |i - j| <= k
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    resultSet.add(i);
                }
            }
        }

        // Convert the set to a list and sort it
        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        return resultList;
    }
}
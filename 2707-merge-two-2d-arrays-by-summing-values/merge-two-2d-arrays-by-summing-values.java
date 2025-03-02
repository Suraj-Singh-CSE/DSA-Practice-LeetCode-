

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }
        
        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }
        
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }
        
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums1 = {{1,2}, {2,3}, {4,5}};
        int[][] nums2 = {{1,4}, {3,2}, {4,1}};
        int[][] result = sol.mergeArrays(nums1, nums2);
        
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

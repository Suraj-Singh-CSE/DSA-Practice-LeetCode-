class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBSTRecursive(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null; 
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]); 
        node.left = constructBSTRecursive(nums, left, mid - 1);
        node.right = constructBSTRecursive(nums, mid + 1, right); 
        return node; 
    }
}

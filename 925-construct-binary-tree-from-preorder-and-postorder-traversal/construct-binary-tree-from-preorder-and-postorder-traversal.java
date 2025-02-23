/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Store postorder value indices for quick lookup
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int left, int right) {
        if (left > right || preIndex >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        // If there is another node to process and it is within the bounds of postorder
        if (preIndex < preorder.length && left <= right) {
            int postLeftIndex = postIndexMap.get(preorder[preIndex]);
            if (postLeftIndex <= right) {
                root.left = construct(preorder, postorder, left, postLeftIndex);
                root.right = construct(preorder, postorder, postLeftIndex + 1, right - 1);
            }
        }
        return root;
    }
}

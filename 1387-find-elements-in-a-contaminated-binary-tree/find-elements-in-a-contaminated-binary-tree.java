import java.util.HashSet;
import java.util.Set;

class FindElements {
    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0; // Start with root as 0
            recoverTree(root);
        }
    }

    private void recoverTree(TreeNode node) {
        if (node == null) return;
        values.add(node.val); // Store value for O(1) lookup

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            recoverTree(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recoverTree(node.right);
        }
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Usage:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

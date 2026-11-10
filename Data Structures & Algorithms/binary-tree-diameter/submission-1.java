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
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        dfs(root);
        return this.max;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}

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
    private boolean valid(int min, TreeNode node, int max){
        if(node==null) return true;
        if(node.val <= min || node.val >= max) return false;
        return valid(min, node.left, node.val) && valid(node.val, node.right, max);
    }
    public boolean isValidBST(TreeNode root) {
        return valid(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }
}

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
    private int ans=-1, pos=0, k;
    private void inorder(TreeNode node){
        if(node==null || ans!=-1) return;
        inorder(node.left);
        ++pos;
        if(pos==k){
            ans=node.val;
            return;
        }
        inorder(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.ans=-1;
        this.pos=0;
        this.k=k;
        inorder(root);
        return ans;
    }
}

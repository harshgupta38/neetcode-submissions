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
    private int[] preorder;
    private int index, n;
    private Map<Integer, Integer> map;

    private TreeNode build(int left, int right){
        if(left>right) return null;
        
        int val=preorder[index++];
        int mid=map.get(val);
        TreeNode node=new TreeNode(val);
        node.left=build(left, mid-1);
        node.right=build(mid+1, right);
        return node;
    } 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.index=0;
        this.n=preorder.length;
        this.map=new HashMap<>();
        for(int i=0;i<n;i++)
        map.put(inorder[i], i);
        return build(0, n-1);
    }
}

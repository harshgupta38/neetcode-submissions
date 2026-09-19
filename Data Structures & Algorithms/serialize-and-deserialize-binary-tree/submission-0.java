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

public class Codec {

    private void breakTree(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("X,");
            return;
        }

        sb.append(node.val).append(",");
        breakTree(node.left, sb);
        breakTree(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        breakTree(root, sb);
        return sb.toString();
    }

    private String[] values;
    private int index, n;

    private TreeNode buildTree(){
        String str = values[index++];
        if (str.equals("X"))
            return null;

        int val = Integer.parseInt(str);
        TreeNode node=new TreeNode(val);
        node.left=buildTree();
        node.right=buildTree();
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.values=data.split(",");
        this.index=0;
        return buildTree();
    }
}

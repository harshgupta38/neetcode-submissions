class Solution {
    private boolean balaned;

    private int height(TreeNode node){
        if(node ==null || !balaned) return 0;

        int left=height(node.left);
        int right=height(node.right);

        if(Math.abs(left-right)>1){
            balaned=false;
            return 0;
        }
        return Math.max(left, right)+1;
    }

    public boolean isBalanced(TreeNode root) {
        this.balaned=true;
        height(root);
        return this.balaned;
    }
}

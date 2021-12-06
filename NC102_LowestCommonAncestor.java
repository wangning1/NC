public class LowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return helper(root, o1, o2).val;
    }

    TreeNode helper(TreeNode node, int o1, int o2){
        if(node == null || node.val == o1 || node.val == o2){
            return node;
        }
        TreeNode left = helper(node.left, o1, o2);
        TreeNode right = helper(node.right, o1, o2);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return node;
    }
}

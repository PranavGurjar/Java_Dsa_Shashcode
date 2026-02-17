package Tree_Data_Structure;

public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(12);

        boolean balanced = isBalanced(root);
        System.out.println("balanced : "+balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        if (height == -1) return false;
        return true;
//        return (height == -1);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;

        //post order traversal
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);

        if (leftSubtreeHeight == -1 || rightSubtreeHeight == -1){
            return -1;
        }

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1){
            return -1;
        }
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}

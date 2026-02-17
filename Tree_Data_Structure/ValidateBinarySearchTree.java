package Tree_Data_Structure;

public class ValidateBinarySearchTree {
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.right = new TreeNode(30);    //11

        boolean validBST = isValidBST(root);
        System.out.println("validBST : "+validBST);
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode root, long min, long max) {
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }

        boolean leftSubtree = validate(root.left, min, root.val);
        boolean rightSubtree = validate(root.right, root.val, max);
        return (leftSubtree && rightSubtree);
    }
}

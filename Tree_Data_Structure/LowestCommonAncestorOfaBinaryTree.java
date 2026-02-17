package Tree_Data_Structure;

public class LowestCommonAncestorOfaBinaryTree {
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
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(9);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(14);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(1);


        TreeNode p = findNode(root, 15);
        TreeNode q = findNode(root, 1);

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
        System.out.println("lowestCommonAncestor : "+lowestCommonAncestor.val);
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        TreeNode left = findNode(root.left, val);
        if (left != null) return left;

        return findNode(root.right, val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

        if (leftChild == null){
            return rightChild;
        }
        else if (rightChild == null){
            return leftChild;
        }
        else {
            return root;
        }
    }
}


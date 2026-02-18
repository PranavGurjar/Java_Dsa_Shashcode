package Tree_Data_Structure;

public class LowestCommonAncestorOfaBinarySearchTree {

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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(14);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(12);

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(13);

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);

        System.out.println("lowestCommonAncestor : "+lowestCommonAncestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        //check if both nodes are on the left
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            //current node are spliting point
            return root;
        }
    }
}



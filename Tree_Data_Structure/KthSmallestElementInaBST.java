package Tree_Data_Structure;

public class KthSmallestElementInaBST {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(7);

        int k = 4;
        int kthSmallest = kthSmallest(root, k);
        System.out.println("kthSmallest : "+kthSmallest);

    }

    static int pos = 0;

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode node = inorderTraversal(root, k);
        if (node == null){
            return -1;
        }
        return node.val;
    }

    public static TreeNode inorderTraversal(TreeNode root, int k){
        if (root == null) return root;

        TreeNode left = inorderTraversal(root.left, k);
        if (left != null){
            return left;
        }
        //print the root
        pos++;
        //current node is the target(Kth smallest)
        if (pos == k){
            return root;
        }

        return inorderTraversal(root.right, k);

//        TreeNode right = inorderTraversal(root.right, k);
//        if (right != null){
//            return right;
//        }
//        return null;
    }
}



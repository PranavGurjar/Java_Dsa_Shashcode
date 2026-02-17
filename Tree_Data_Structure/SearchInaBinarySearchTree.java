package Tree_Data_Structure;

public class SearchInaBinarySearchTree {

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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 10;

        TreeNode searchBST = searchBST(root, val);
        System.out.println("searchBST : " + (searchBST == null ? null : searchBST.val));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }

        TreeNode ans = null;
        if (val < root.val){
            ans = searchBST(root.left, val);
        }
        else {
            ans = searchBST(root.right, val);
        }
        return ans;     //null or address of the node
    }
}



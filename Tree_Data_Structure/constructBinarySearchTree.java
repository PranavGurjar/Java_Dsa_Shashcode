package Tree_Data_Structure;


import java.util.Arrays;

public class constructBinarySearchTree {
    class TreeNode {
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
        int arr[] = {9, 8, 4, 6, 11, 15, 7, 19, 10};

        System.out.println("tree arr : "+Arrays.toString(arr));

        constructBinarySearchTree obj = new constructBinarySearchTree();
        TreeNode root = obj.constructBST(arr);

        System.out.print("InOrder BST : ");
        obj.inorderTraversal(root);
    }

    public void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        //left
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        //right
        inorderTraversal(root.right);
    }

    public TreeNode constructBST(int arr[]){
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertIntoBST(root, arr[i]);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
package Tree_Data_Structure;

import java.util.ArrayList;

public class TwoSum_IV_Input_Is_a_BST {
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
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        boolean target = findTarget(root, k);
        System.out.println("target : "+target);
    }

    public static boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int start = 0;
        int end = inorder.size()-1;
        while (start < end){
            int sum = inorder.get(start) + inorder.get(end);
            if (sum == k){
                return true;
            }

            if (sum < k){
                start++;
            }
            else {
                end--;
            }
        }
        return false;
    }

    public static void inorderTraversal(TreeNode root, ArrayList<Integer> inorder){
        if (root == null){
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}
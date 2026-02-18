package Tree_Data_Structure;

import java.util.Stack;

public class BinarySearchTreeIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right = new TreeNode(18);

        BSTIterator(root);

        while (hasNext()){
            System.out.print(next()+" ");
        }
    }

    static Stack<TreeNode> stack;

    public static void BSTIterator(TreeNode root) {
        stack = new Stack<>();

        //insert left boundary
        TreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public static int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null){
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    public static boolean hasNext() {
        return !stack.isEmpty();
    }
}
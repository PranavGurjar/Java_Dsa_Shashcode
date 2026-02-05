package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class IterativePreorderTraversal {
    static class PreNode<E> {
        E val;
        PreNode left;
        PreNode right;

        public PreNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        PreNode<Integer> root = new PreNode<>(1);
        root.left = new PreNode<>(2);
        root.right = new PreNode<>(3);
        root.left.left = new PreNode<>(4);
        root.left.right = new PreNode<>(5);
        root.right.right = new PreNode<>(6);

        List<Integer> preOrder = preorderTraversal(root);
        System.out.println("preOrder : "+preOrder);
    }

    //144. Binary Tree Preorder Traversal
    public static List<Integer> preorderTraversal(PreNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<PreNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            PreNode<Integer> node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}


package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class IterativeInorderTraversal {
    static class InNode<E> {
        E val;
        InNode left;
        InNode right;

        InNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        InNode<Integer> root = new InNode<>(1);
        root.left = new InNode<>(2);
        root.right = new InNode<>(3);
        root.left.left = new InNode<>(4);
        root.left.right = new InNode<>(5);
        root.right.right = new InNode<>(6);

        List<Integer> inorder = inorderTraversal(root);
        System.out.println("inorder : "+inorder);
    }

    //94. Binary Tree Inorder Traversal
    public static List<Integer> inorderTraversal(InNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<InNode> stack = new Stack<>();
        InNode<Integer> node = root;

        while (!stack.isEmpty() || node != null){
            //move to the left
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            //print the root
            node = stack.pop();
            res.add(node.val);

            //move to the right subtree
            node = node.right;
        }
        return res;
    }
}


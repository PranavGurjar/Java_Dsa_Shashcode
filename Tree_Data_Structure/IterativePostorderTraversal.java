package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorderTraversal {
    static class PostNode<E> {
        E val;
        PostNode left;
        PostNode right;

        public PostNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        PostNode<Integer> root = new PostNode<>(1);
        root.left = new PostNode<>(2);
        root.right = new PostNode<>(3);
        root.left.left = new PostNode<>(4);
        root.left.right = new PostNode<>(5);
        root.right.right = new PostNode<>(6);

        List<Integer> postOrder = postorderTraversal(root);
        System.out.println("postOrder : "+postOrder);
    }

    //145. Binary Tree Postorder Traversal
    public static List<Integer> postorderTraversal(PostNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        Stack<PostNode> stack = new Stack<>();
        if (root == null) return res;
        PostNode<Integer> node = root;
        while (node != null || !stack.isEmpty()){
            //move to the left
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            //move to the right
            if (stack.peek().right != null){
                node = stack.peek().right;
            }
            else {
                PostNode<Integer> temp = stack.pop();
                res.add(temp.val);
                while (!stack.isEmpty() && temp == stack.peek().right){
                    temp = stack.pop();
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}


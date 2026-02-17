package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.Stack;

public class TreeBoundaryTraversalOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.right.right.left = new Node(11);

        ArrayList<Integer> boundaryTraversal = boundaryTraversal(root);
        System.out.println("boundaryTraversal : "+boundaryTraversal);
    }

    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        //insert the root
        if (!isLeaf(root)){
            res.add(root.data);
        }

        //left boundary
        insertLeftBoundary(res, root);

        //leaf boundary
        insertLeafBoundary(res, root);

        //right boundary
        insertRightBoundary(res, root);

        return res;
    }

    public static boolean isLeaf(Node node){
        return  (node.left == null && node.right == null);
    }

    public static void insertLeftBoundary(ArrayList<Integer> res, Node root){
        Node leftNode = root.left;
        while (leftNode != null){
            if (isLeaf(leftNode)){
                break;
            }
            res.add(leftNode.data);
            if (leftNode.left != null){
                leftNode = leftNode.left;
            }
            else {
                leftNode = leftNode.right;
            }
        }
    }

    public static void insertRightBoundary(ArrayList<Integer> res, Node root){
        Node rightNode = root.right;
        Stack<Integer> stack = new Stack<>();
        while (rightNode != null){
            if (isLeaf(rightNode)){
                break;
            }
            stack.push(rightNode.data);
            // res.add(rightNode);
            if (rightNode.right != null){
                rightNode = rightNode.right;
            }
            else {
                rightNode = rightNode.left;
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
    }

    public static void insertLeafBoundary(ArrayList<Integer> res, Node root){
        if (root == null) return;

        if (isLeaf(root)){
            res.add(root.data);
        }

        insertLeafBoundary(res, root.left);
        insertLeafBoundary(res, root.right);

    }
}


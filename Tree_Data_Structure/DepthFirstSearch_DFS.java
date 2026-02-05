package Tree_Data_Structure;

import java.util.ArrayList;

public class DepthFirstSearch_DFS {
    static class DFS_Node<E> {
        E data;
        DFS_Node left;
        DFS_Node right;

        DFS_Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        DFS_Node<Integer> root = new DFS_Node<>(1);
        root.left = new DFS_Node<>(2);
        root.right = new DFS_Node<>(3);
        root.left.left = new DFS_Node<>(4);
        root.left.right = new DFS_Node<>(5);
        root.right.right = new DFS_Node<>(6);

        ArrayList<Integer> preOrder = preOrder(root);
        System.out.println("preOrder : "+preOrder);

        ArrayList<Integer> inOrder = inOrder(root);
        System.out.println("inOrder : "+inOrder);

        ArrayList<Integer> postOrder = postOrder(root);
        System.out.println("postOrder : "+postOrder);
    }

    public static ArrayList<Integer> preOrder(DFS_Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        return res;
    }

    public static void preOrderTraversal(DFS_Node<Integer> root, ArrayList<Integer> res){
        if (root == null) return;
        res.add(root.data);
        preOrderTraversal(root.left, res);
        preOrderTraversal(root.right, res);
    }

    public static ArrayList<Integer> inOrder(DFS_Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    public static void inOrderTraversal(DFS_Node<Integer> root, ArrayList<Integer> res){
        if (root == null) return;
        inOrderTraversal(root.left, res);
        res.add(root.data);
        inOrderTraversal(root.right, res);
    }

    public static ArrayList<Integer> postOrder(DFS_Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        return res;
    }

    public static void postOrderTraversal(DFS_Node<Integer> root, ArrayList<Integer> res){
        if (root == null) return;
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.data);
    }
}


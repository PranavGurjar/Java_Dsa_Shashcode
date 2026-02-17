package Tree_Data_Structure;

import java.util.*;

public class BottomViewOfBinaryTree {
    static class Node<E>{
        E data;
        Node<Integer> left;
        Node<Integer> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(7);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(4);
        root.left.right.left = new Node<>(5);
        root.right.left = new Node<>(10);
        root.right.right = new Node<>(8);
        root.right.left.right = new Node<>(9);

        ArrayList<Integer> bottomView = bottomView(root);
        System.out.println("bottomView : "+bottomView);
    }

    static class CustomNode{
        Node<Integer> node;
        int col;

        public CustomNode(Node<Integer> node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public static ArrayList<Integer> bottomView(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root, 0));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()){
            CustomNode customNode = queue.poll();
            Node<Integer> node = customNode.node;
            int col = customNode.col;

            map.put(col, node.data);    //left -> right

            if (node.left != null){
                queue.offer(new CustomNode(node.left, col-1));
            }

            if (node.right != null){
                queue.offer(new CustomNode(node.right, col+1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
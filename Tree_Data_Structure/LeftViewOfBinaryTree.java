package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    static class Node<E>{
        E data;
        Node left;
        Node right;

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
        root.right.left = new Node<>(8);
        root.right.right = new Node<>(9);
        root.left.left.left = new Node<>(10);

        ArrayList<Integer> leftedView1 = leftView1(root);
        System.out.println("leftedView1 : "+leftedView1);

        ArrayList<Integer> leftedView2 = leftView2(root);
        System.out.println("leftedView2 : "+leftedView2);
    }

    public static ArrayList<Integer> leftView1(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        //bfs
        while (!queue.isEmpty()){
            int size = queue.size();    //1

            if (size > 0){
                Node<Integer> node = queue.peek();
                res.add(node.data);
            }
            while (size > 0){
                Node<Integer> node = queue.poll();

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return res;
    }

    public static ArrayList<Integer> leftView2(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        //bfs
        while (!queue.isEmpty()){
            int size = queue.size();    //1

            for (int i = 0; i < size; i++) {
                Node<Integer> node = queue.poll();
                if (i == 0){
                    res.add(node.data);
                }

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}

package Tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfBinaryTree {

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

        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(20);
        root.right = new Node<>(30);
        root.left.left = new Node<>(40);
        root.left.right = new Node<>(60);

        int sumBT1 = sumBT1(root);
        System.out.println("sumBT1 : "+ sumBT1);

        int sumBT2 = sumBT2(root);
        System.out.println("sumBT2 : "+ sumBT2);
    }

    //DFS
    static int sumBT1(Node<Integer> root) {
        if(root == null) return 0;

        int leftSum = sumBT1(root.left);
        int rightSum = sumBT1(root.right);

        return (root.data + leftSum + rightSum);
    }

    //BFS
    static int sumBT2(Node<Integer> root) {
        if (root == null) return 0;

        int sum = 0;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node<Integer> current = queue.poll();
            sum += current.data;

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }

        return sum;
    }
}



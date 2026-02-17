package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfN_aryTree {
    public static void main(String[] args) {

        // Build the tree for input: [1,null,3,2,4,null,5,6]

        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        Node root = new Node(1, Arrays.asList(node3, node2, node4));

        int maxDepth = maxDepth(root);
        System.out.println("maxDepth : "+maxDepth);
    }

    static class Node<E>{
        E val;
        List<Node> children;

        public Node(E val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static int maxDepth(Node<Integer> root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node<Integer> node : root.children){
            if (node != null){
                maxDepth = Math.max(maxDepth, maxDepth(node));
            }
        }
        return (1+maxDepth);
    }
}


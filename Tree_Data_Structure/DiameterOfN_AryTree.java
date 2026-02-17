package Tree_Data_Structure;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DiameterOfN_AryTree {
    static class Node<E>{
        E val;
        List<Node> children;

        public Node(E val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        Node root = new Node(1, Arrays.asList(node3, node2, node4));

        int diameter = diameter(root);
        System.out.println("diameter : "+diameter);
    }

    //Facebook Interview Question
    public static int diameter(Node<Integer> root){
        int maxi[] = new int[1];
        findHeight(root, maxi);
        return maxi[0];
    }

    public static int findHeight(Node<Integer> root, int maxi[]){
        if (root == null) return 0;
        
        int h1 = 0;
        int h2 = 0;
        int h = 0;

        for(Node<Integer> node : root.children){
            h = findHeight(node, maxi);
            if (h > h1){
                h2 = h1;
                h1 = h;
            }
            else if (h > h2){
                h2 = h;
            }
        }
        maxi[0] = Math.max(maxi[0], h1 + h2);
        return (1 + h1);
    }
}
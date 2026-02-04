package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_Array_Tree_BFS {
    static class NArrayTreeNode<E>{
        E data;
        ArrayList<NArrayTreeNode> children;

        public NArrayTreeNode(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public NArrayTreeNode(E data, ArrayList<NArrayTreeNode> children) {
            this.data = data;
            this.children = children;
        }
    }
    public static void main(String[] args) {
        NArrayTreeNode<Integer> root = new NArrayTreeNode<>(10);

        NArrayTreeNode<Integer> n1 = new NArrayTreeNode<>(20);
        NArrayTreeNode<Integer> n2 = new NArrayTreeNode<>(30);
        NArrayTreeNode<Integer> n3 = new NArrayTreeNode<>(40);
        NArrayTreeNode<Integer> n4 = new NArrayTreeNode<>(50);

        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        n1.children.add(new NArrayTreeNode<>(60));
        n1.children.add(new NArrayTreeNode<>(70));
        n1.children.add(new NArrayTreeNode<>(80));

        n4.children.add(new NArrayTreeNode<>(90));

        List<List<Integer>> levelOrder = levelOrder(root);
        System.out.println("levelOrder : "+ levelOrder);
    }

    public static List<List<Integer>> levelOrder(NArrayTreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<NArrayTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> result = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                NArrayTreeNode<Integer> node = queue.poll();
                result.add(node.data);
                for (NArrayTreeNode child : node.children){
                    if (child != null){
                        queue.offer(child);
                    }
                }
                size--;
            }
            res.add(result);
        }
        return res;
    }
}

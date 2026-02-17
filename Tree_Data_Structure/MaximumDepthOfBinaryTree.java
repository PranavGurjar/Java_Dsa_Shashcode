package Tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    static class DepthNode<E> {
        E val;
        DepthNode left;
        DepthNode right;

        public DepthNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        DepthNode<Integer> root = new DepthNode<>(3);
        root.left = new DepthNode<>(9);
        root.right = new DepthNode<>(20);
        root.right.left = new DepthNode<>(15);
        root.right.right = new DepthNode<>(7);

        int maxDepth_bfs = maxDepth_BFS(root);
        System.out.println("maxDepth_bfs : "+maxDepth_bfs);

        int maxDepth_dfs = maxDepth_DFS(root);
        System.out.println("maxDepth_dfs : "+maxDepth_dfs);
    }

    public static int maxDepth_BFS(DepthNode<Integer> root) {
        if (root == null){
            return 0;
        }
        Queue<DepthNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                DepthNode<Integer> node = queue.poll();
                size--;

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()){
                level++;
            }
        }
        return (level+1);
    }

    public static int maxDepth_DFS(DepthNode<Integer> root) {
        if (root == null){
            return 0;
        }
        //left height
        int lh = maxDepth_DFS(root.left);
        //right height
        int rh = maxDepth_DFS(root.right);

        return (1 + Math.max(lh, rh));
    }
}

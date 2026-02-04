package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch_BFS {
    static class TreeNode<E> {
        TreeNode left;
        TreeNode right;
        E data;

        public TreeNode(E data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode<>(10);
        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);
        root.left.left = new TreeNode<>(40);
        root.left.right = new TreeNode<>(50);
        ArrayList<ArrayList<Integer>> levelOrder = levelOrder(root);
        System.out.println("levelOrder : "+levelOrder);



        TreeNode<Integer> root1 = new TreeNode<>(10);
        root1.left = new TreeNode<>(20);
        root1.right = new TreeNode<>(30);
        root1.left.left = new TreeNode<>(40);
        root1.left.right = new TreeNode<>(50);

//        TreeNode<Integer> []root = {10, 20, 30, 40, 50};
        ArrayList<Integer> bfs = BFS(root1);
        System.out.println("bfs : "+bfs);
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> res = new ArrayList<>();   // moved inside

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                res.add(node.data);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(res);   // moved outside inner loop
        }
        return result;
    }


    public static ArrayList<Integer> BFS(TreeNode<Integer> root){
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            res.add(node.data);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return res;
    }
}
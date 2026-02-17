package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        public TreeNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(7);
        root.left.left = new TreeNode<>(3);
        root.right.left = new TreeNode<>(8);
        root.right.right = new TreeNode<>(9);
        root.left.left.left = new TreeNode<>(10);

        List<Integer> rightSideView1 = rightSideView1(root);
        System.out.println("rightSideView1 : "+rightSideView1);

        List<Integer> rightSideView2 = rightSideView2(root);
        System.out.println("rightSideView2 : "+rightSideView2);
    }

    public static List<Integer> rightSideView1(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        //bfs
        while (!queue.isEmpty()){
            int size = queue.size();    //1

            while (size > 0){
                TreeNode<Integer> node = queue.poll();

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
                if (size == 0){
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static List<Integer> rightSideView2(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        //bfs
        while (!queue.isEmpty()){
            int size = queue.size();    //1

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (i == size-1){
                    res.add(node.val);
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
package Tree_Data_Structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(root);
        System.out.println("zigzagLevelOrder : "+zigzagLevelOrder);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        //apply LOT
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelSubList = new LinkedList<>();
            while (size>0){
                //bfs
                TreeNode node = queue.poll();
                if (level%2 == 0){
                    levelSubList.addLast(node.val);
                }
                else {
                    levelSubList.addFirst(node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
            res.add(levelSubList);
        }
        return res;
    }
}
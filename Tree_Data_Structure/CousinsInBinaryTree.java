package Tree_Data_Structure;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
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
        TreeNode<Integer> root = new TreeNode<>(7);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.right = new TreeNode<>(5);
        int x = 3, y = 5;

        boolean cousins1 = isCousins1(root, x, y);
        System.out.println("cousins1 : "+cousins1);

        boolean cousins2 = isCousins2(root, x, y);
        System.out.println("cousins2 : "+cousins2);
    }

    public static boolean isCousins1(TreeNode<Integer> root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int childCount = 0;
            //check at same level
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                int sameParentCount = 0;
                if (node.left != null){
                    if (node.left.val.equals(x) || node.left.val.equals(y)){
                        sameParentCount++;
                        childCount++;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null){
                    if (node.right.val.equals(x) || node.right.val.equals(y)){
                        sameParentCount++;
                        childCount++;
                    }
                    queue.offer(node.right);
                }

                if (sameParentCount == 2){
                    return false;
                }
            }
            if (childCount == 2){
                return true;
            }
            if (childCount == 1){
                return false;
            }
        }
        return false;
    }

    static TreeNode<Integer> xParent = null, yParent = null;
    static int xDepth = -1, yDepth = -1;

    public static boolean isCousins2(TreeNode<Integer> root, int x, int y) {

        dfs(root, null, 0, x, y);

        return xDepth == yDepth && xParent != yParent;
    }

    private static void dfs(TreeNode<Integer> node, TreeNode<Integer> parent, int depth, int x, int y) {

        if (node == null)
            return;

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
        }

        if (node.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }
}

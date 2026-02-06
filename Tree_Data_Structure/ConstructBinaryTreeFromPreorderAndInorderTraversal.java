package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static class Build1Node<E> {
        E val;
        Build1Node left;
        Build1Node right;

        public Build1Node(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]

        int []preorder = {3,9,20,15,7};
        int []inorder = {9,3,15,20,7};
        Build1Node<Integer> root = buildTree(preorder, inorder);
        ArrayList<String> res = printTree(root);
        System.out.println("Tree res : "+res);
    }

    public static ArrayList<String> printTree(Build1Node<Integer> root){
        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Build1Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Build1Node<Integer> node = queue.poll();

            if (node == null){
                res.add("null");
                continue;
            }

            res.add(String.valueOf(node.val));

            queue.offer(node.left);
            queue.offer(node.right);
        }
        // ✅ remove extra trailing nulls
        while (!res.isEmpty() && res.get(res.size() - 1).equals("null")) {
            res.remove(res.size() - 1);
        }
        return res;
    }

    public static Build1Node<Integer> buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //hash the value with index
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = preorder.length-1;
        int m = inorder.length-1;
        Build1Node<Integer> root = constructTree(preorder, inorder, indexMap, 0, n, 0, m);
        return root;
    }

    public static Build1Node<Integer> constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> indexMap,
                                           int preIndStart, int preIndEnd, int inIndStart, int inIndEnd) {
        //handle the base case
        if (preIndStart > preIndEnd || inIndStart > inIndEnd){
            return null;
        }

        int rootData = preorder[preIndStart];
        int rootIndex = indexMap.get(rootData);
        Build1Node<Integer> root = new Build1Node<Integer>(rootData);
        int leftTreeSize = rootIndex - inIndStart;
        int rightTreeSize = inIndEnd - rootIndex;

        root.left = constructTree(preorder, inorder, indexMap,
                preIndStart+1, preIndStart+leftTreeSize,
                inIndStart, rootIndex-1);
        root.right = constructTree(preorder, inorder, indexMap,
                preIndStart+leftTreeSize+1, preIndStart+leftTreeSize+rightTreeSize,
                rootIndex+1, inIndEnd);
        return root;
    }
}

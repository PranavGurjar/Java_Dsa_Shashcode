package Tree_Data_Structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    static class Build2Node<E>{
        E val;
        Build2Node left;
        Build2Node right;

        public Build2Node(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
//        Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//        Output: [3,9,20,null,null,15,7]

        int []inorder = {9,3,15,20,7};
        int []postorder = {9,15,7,20,3};
        Build2Node<Integer> root = buildTree(inorder, postorder);
        ArrayList<String> res = printTree(root);
        System.out.println("Tree res : "+res);
    }

    public static ArrayList<String> printTree(Build2Node<Integer> root){
        ArrayList<String> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Build2Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Build2Node<Integer> node = queue.poll();

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

    public static Build2Node<Integer> buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //hash the value with index
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = postorder.length-1;
        int m = inorder.length-1;
        Build2Node<Integer> root = constructTree(postorder, inorder, indexMap, 0, n, 0, m);
        return root;
    }

    public static Build2Node<Integer> constructTree(int[] postorder, int[] inorder,
                                                    HashMap<Integer, Integer> indexMap,
                                                    int postIndStart, int postIndEnd,
                                                    int inIndStart, int inIndEnd) {
        //handle the base case
        if (postIndStart > postIndEnd || inIndStart > inIndEnd){
            return null;
        }

        int rootData = postorder[postIndEnd];
        int rootIndex = indexMap.get(rootData);
        Build2Node<Integer> root = new Build2Node<>(rootData);
        int leftTreeSize = rootIndex - inIndStart;
        int rightTreeSize = inIndEnd - rootIndex;

        root.left = constructTree(postorder, inorder, indexMap,
                postIndStart, postIndStart+leftTreeSize-1,
                inIndStart, rootIndex-1);
        root.right = constructTree(postorder, inorder, indexMap,
                postIndStart+leftTreeSize, postIndStart+leftTreeSize+rightTreeSize-1,
                rootIndex+1, inIndEnd);
        return root;
    }
}


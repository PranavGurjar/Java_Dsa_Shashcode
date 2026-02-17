package Tree_Data_Structure;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    static class TreeNode{
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
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        List<List<Integer>> verticalTraversal = verticalTraversal(root);
        System.out.println("verticalTraversal : "+verticalTraversal);

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //col -> [level -> [list]]
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        //dfs - bfs
        dfs(root, map, 0, 0);       //dfs call to fill the map
        //take care of sorting and fill the res;
        //[column wise sorting]
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()){
            TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            //[level wise sorting]
            for (Map.Entry<Integer, ArrayList<Integer>> subEntry : levelMap.entrySet()){
                ArrayList<Integer> subList = subEntry.getValue();
                Collections.sort(subList);
                list.addAll(subList);
            }
            res.add(list);
        }
        return res;
    }

    private static void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map, int col, int level) {
        if (root == null) return;

        //insert in map
        //col
        if (!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }
        //level
        if (!map.get(col).containsKey(level)){
            map.get(col).put(level, new ArrayList<>());
        }
        map.get(col).get(level).add(root.val);
        dfs(root.left, map,col-1, level+1);
        dfs(root.right, map,col+1, level+1);
    }
}


package Tree_Data_Structure;

public class MaximumSumBSTinBinaryTree {
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(80);
        root.right.right = new TreeNode(55);
        root.left.right.left = new TreeNode(22);
        root.left.right.right = new TreeNode(27);
        root.right.right.left = new TreeNode(70);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.left = new TreeNode(5);
        root.right.right.right.right = new TreeNode(15);

        int maxSumBST = maxSumBST(root);
        System.out.println("maxSumBST : "+maxSumBST);
    }

    static int ans = 0;

    public static int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // arr -> min, max, sum
    public static int[] dfs(TreeNode root){
        //base case
        if (root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int []leftSubtree = dfs(root.left);
        int []rightSubtree = dfs(root.right);
        //check if current subtree is bst
        if (root.val > leftSubtree[1] && root.val < rightSubtree[0]){
            int curSum = leftSubtree[2] + rightSubtree[2] + root.val;
            ans = Math.max(ans, curSum);
            int minVal = Math.min(root.val, leftSubtree[0]);
            int maxVal = Math.max(root.val, rightSubtree[1]);
            return new int[]{minVal, maxVal, curSum};
        }
        int maxSum = Math.max(leftSubtree[2], rightSubtree[2]);
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, maxSum};
    }
}
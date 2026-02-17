package Tree_Data_Structure;

public class DiameterOfBinaryTree {
    static class DiaNode{
        int val;
        DiaNode left;
        DiaNode right;

        public DiaNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        DiaNode root = new DiaNode(1);
        root.left = new DiaNode(2);
        root.right = new DiaNode(3);
        root.left.left = new DiaNode(4);
        root.left.right = new DiaNode(5);
        int diameterOfBinaryTree = diameterOfBinaryTree(root);
        System.out.println("diameterOfBinaryTree : "+diameterOfBinaryTree);
    }

    public static int diameterOfBinaryTree(DiaNode root) {
        int maxi[] = new int[1];    //pass by reference
        maxi[0] = 0;
        findHeight(root, maxi);
        return maxi[0];
    }

    public static int findHeight(DiaNode root, int maxi[]){
        if (root == null){
            return 0;
        }
        int leftHeight = findHeight(root.left, maxi);
        int rightHeight = findHeight(root.right, maxi);
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);
        return (1 + Math.max(leftHeight, rightHeight));
    }
}



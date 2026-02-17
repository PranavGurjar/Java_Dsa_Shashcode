package Tree_Data_Structure;

public class CountNumberOfNodesInABinaryTree {
    static class CountNode<E>{
        E val;
        CountNode left;
        CountNode right;

        public CountNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        //int []root = {1,2,3,4,5,6};     // Output : 6

        CountNode<Integer> root = new CountNode<>(1);
        root.left = new CountNode<>(2);
        root.right = new CountNode<>(3);
        root.left.left = new CountNode<>(4);
        root.left.right = new CountNode<>(5);
        root.right.left = new CountNode<>(6);

        int countNodes1 = countNodes1(root);
        System.out.println("countNodes1 : "+countNodes1);

        int countNodes2 = countNodes2(root);
        System.out.println("countNodes2 : "+countNodes2);
    }

    //O(N)
    public static int countNodes1(CountNode<Integer> root) {
        if (root == null) return 0;

        int lNode = countNodes1(root.left);
        int rNode = countNodes1(root.right);
        return (1 + lNode + rNode);
    }

    public static int countNodes2(CountNode<Integer> root) {
        if(root == null){
            return 0;
        }
        //check if all levels are completely filled
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight){
            return ((int) Math.pow(2, leftHeight)-1);
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    public static int findLeftHeight(CountNode<Integer> root){
        int count = 1;
        while (root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public static int findRightHeight(CountNode<Integer> root){
        int count = 1;
        while (root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}


package Tree_Data_Structure;

public class InsertIntoaBinarySearchTree {

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

    public void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        //left
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        //right
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        InsertIntoaBinarySearchTree insertObj = new InsertIntoaBinarySearchTree();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(18);


        System.out.print("before root : ");
        insertObj.inorderTraversal(root);
        System.out.println();

        int val = 30;
        insertIntoBST1(root, val);
//        insertIntoBST2(root, val);

        System.out.print("after root : ");
        insertObj.inorderTraversal(root);
        System.out.println();

    }

    //iterative approach
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        //find the pos and insert
        TreeNode temp = root;
        while (temp != null){
            if (val < temp.val){
                //left subtree
                if (temp.left == null){
                    temp.left = new TreeNode(val);
                    break;
                }
                else {
                    temp = temp.left;
                }
            }
            else {
                //right subtree
                if (temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                }
                else {
                    temp = temp.right;
                }
            }
        }

        return root;
    }

    //recursive approach
    public static TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val){
            root.left = insertIntoBST2(root.left, val);
        }
        else {
            root.right = insertIntoBST2(root.right, val);
        }

        return root;
    }
}


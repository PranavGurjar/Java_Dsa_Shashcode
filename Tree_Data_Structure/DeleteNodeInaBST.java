package Tree_Data_Structure;

public class DeleteNodeInaBST {

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
        root.left = new TreeNode(8);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(19);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right.left.right = new TreeNode(15);

        System.out.print("Before Inorder Tree : ");
        inorderTraversal(root);
        System.out.println();

        int key = 10;       //8, 14
        deleteNode(root, key);

        System.out.print("After Inorder Tree : ");
        inorderTraversal(root);
        System.out.println();
    }

    public static void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        //left
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        //right
        inorderTraversal(root.right);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else {
            //root.val == key
            //leaf node
            if (root.left == null && root.right == null){
                return null;
            }
            //single child case
            if (root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else {
                //2 child case
                //inorder predecessor
                TreeNode predecessor = findPredecessor(root.left);
                //shift the predecessor node
                root.val = predecessor.val;
                //delete predecessor node.val
                root.left = deleteNode(root.left, predecessor.val);


//                //inorder successor
//                TreeNode successor = findSuccessor(root.right);
//                //shift the successor node
//                root.val = successor.val;
//                //delete successor node.val
//                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    private static TreeNode findPredecessor(TreeNode node) {
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    private static TreeNode findSuccessor(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
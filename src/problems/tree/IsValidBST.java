package problems.tree;


public class IsValidBST {

    private static boolean isValidBST(BinaryNode root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return left && right;
    }

    private static boolean isValidBST(BinaryNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(100);
        root.left = new BinaryNode(20);
        root.right = new BinaryNode(200);
        root.left.left = new BinaryNode(10);
        root.left.right = new BinaryNode(30);
        root.right.left = new BinaryNode(150);
        root.right.right = new BinaryNode(300);
        System.out.println(isValidBST(root));
        BinaryTree.printTree(root);
    }

}

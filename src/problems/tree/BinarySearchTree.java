package problems.tree;

public class BinarySearchTree {

    public static void main(String[] args) {

        BinarySearchTree searchTree = new BinarySearchTree();
        BinaryNode root = null;
        int[] tree = {33, 100, 200, 50, 10, 35, 12, 21, 89};
        for (int value : tree) {
            root = searchTree.insert(root, value);
        }
        BinaryTree.printTree(root);
    }

    public BinaryNode insert(BinaryNode root, int value) {

        if (root == null) {
            return new BinaryNode(value);
        }
        if (value < root.val) {
            root.left = insert(root.left, value);
        }
        if (value > root.val) {
            root.right = insert(root.right, value);
        }
        return root;
    }
}

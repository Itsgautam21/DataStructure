package problems.tree;

public class RedBlackTree {

    public BinaryNode root;

    public void insert(int value) {
        if (root == null) {
            root = new BinaryNode(value);
            root.colour = 0;
        }
        else {
            root = insert(root, value);
        }
    }

    private BinaryNode insert(BinaryNode node, int value) {

        if (node == null) {
            return new BinaryNode(value);
        }
        if (value < node.val) {
            node.left = insert(node.left, value);
        } else if (value > node.val) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        if (node.colour == 1 && getColour(node.left) == 1) {


        } else if (node.colour == 1 && getColour(node.right) == 1) {

        }

        return node;
    }

    private int getColour(BinaryNode node) {
        return node == null ? 0 : node.colour;
    }

    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(10);
        redBlackTree.insert(11);
        redBlackTree.insert(12);
        BinaryTree.printTree(redBlackTree.root);
    }

}

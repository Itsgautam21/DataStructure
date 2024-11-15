package problems.tree;

public class AVLTree {

    public BinaryNode root;

    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();

        avlTree.insert(12);
        avlTree.insert(10);
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(7);
        avlTree.insert(15);
        avlTree.insert(16);
        avlTree.insert(17);

        avlTree.delete(17);
        avlTree.delete(15);
        BinaryTree.printTree(avlTree.root);
    }

    public void insert(int value) {

        root = insert(root, value);
    }

    public void delete(int value) {

        root = delete(root, value);
    }

    private BinaryNode delete(BinaryNode node, int value) {

        if (node == null) {
            return null;
        }
        if (value < node.val) {
            node.left = delete(node.left, value);
        } else if (value > node.val) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.val = inorderPredecessor(node.left);
            node.left = delete(node.left, node.val);
            /*
             #Option 2:
             node.val = inorderSuccessor(node.right);
             node.right = delete(node.right, node.val);
             */
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return balance(node);
    }

    /**
     * get minimum value from the right subtree
     *
     * @param node Node
     * @return minimum value from right subtree
     */
    private int inorderSuccessor(BinaryNode node) {

        int minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }

    /**
     * Get maximum value from the left subtree
     *
     * @param node Node
     * @return maximum value from left subtree
     */
    private int inorderPredecessor(BinaryNode node) {

        int maxValue = node.val;
        while (node.right != null) {
            maxValue = node.right.val;
            node = node.right;
        }
        return maxValue;
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
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return balance(node);
    }

    private int getHeight(BinaryNode node) {

        return node == null ? -1 : node.height;
    }

    private int balanceFactor(BinaryNode node) {

        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode balance(BinaryNode node) {

        int balance = balanceFactor(node);
        // Left heavy
        if (balance > 1) {
            // zigzag left-right case
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // all left case
            return rotateRight(node);
        }
        // Right heavy
        if (balance < -1) {
            // zigzag right-left case
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // all right case
            return rotateLeft(node);
        }

        return node;
    }

    private BinaryNode rotateRight(BinaryNode parent) {

        BinaryNode child = parent.left;
        parent.left = child.right;
        child.right = parent;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;
        return child;
    }

    private BinaryNode rotateLeft(BinaryNode parent) {

        BinaryNode child = parent.right;
        parent.right = child.left;
        child.left = parent;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;
        return child;
    }
}

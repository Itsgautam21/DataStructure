package problems.tree;

public class IsBalancedTree {

    public boolean isBalancedTree(BinaryNode root) {

        if (root == null) {
            return true;
        }
        boolean left = isBalancedTree(root.left);
        boolean right = isBalancedTree(root.right);

        if (!left || !right) {
            return false;
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = balanceFactor(root);
        return balance <= 1;
    }

    private int getHeight(BinaryNode node) {
        return node == null ? -1 : node.height;
    }

    private int balanceFactor(BinaryNode node) {
        if (node == null) {
            return 0;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right));
    }

    public static void main(String[] args) {

        IsBalancedTree balancedTree = new IsBalancedTree();
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);
        root.right.right.right = new BinaryNode(8);
        root.right.right.left = new BinaryNode(9);
        root.right.right.right.right = new BinaryNode(10);
        System.out.println(balancedTree.isBalancedTree(root));
        BinaryTree.printTree(root);
    }

}

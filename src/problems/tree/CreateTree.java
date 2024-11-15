package problems.tree;

public class CreateTree {

    public static void main(String[] args) {

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
        BinaryTree.printTree(root);
    }

}

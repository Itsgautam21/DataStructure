package problems.tree;

public class BinaryNode {

    public int val;

    public int height;

    public int colour;

    public BinaryNode left;

    public BinaryNode right;

    public BinaryNode(int value) {

        this.val = value;
        this.height = 0;
        this.colour = 1;
    }
}

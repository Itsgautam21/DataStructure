package problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {

    public int index = 0;

    public BinaryNode createTreeFromArray(Integer[] array) {

        if (index >= array.length || array[index] == null) {
            index++;
            return null;
        }
        BinaryNode root = new BinaryNode(array[index]);
        index++;
        root.left = createTreeFromArray(array);
        root.right = createTreeFromArray(array);
        return root;
    }

    public static void printTree(BinaryNode root) {

        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<BinaryNode> nodes, int level, int maxLevel) {

        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryNode> newNodes = new ArrayList<>();
        for (BinaryNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                //System.out.print(node.val + " (" + node.height + ")");
                //System.out.print(node.val + " (" + node.colour + ")");
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (BinaryNode node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
                if (node.left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);
                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {

        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(BinaryNode node) {

        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<BinaryNode> list) {

        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}

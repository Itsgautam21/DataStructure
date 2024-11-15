package dsa.tree;

import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
    public Node(int data) {
        this.data = data;
    }
}

public class GenericTree {

    int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node root = null;
    Node predecessor, successor;
    int ceil = Integer.MAX_VALUE;
    int floor = Integer.MIN_VALUE;
    int maxSum = Integer.MIN_VALUE;
    int maxSumNode  = 0;
    int state;
    public void createTree(int[] arr) {
        Stack<Node> stack = new Stack<>();
        for (int item : arr) {
            if (item == -1) stack.pop();
            else {
                Node node = new Node(item);
                if (stack.size() > 0) stack.peek().children.add(node);
                else root = node;
                stack.push(node);
            }
        }
    }
    public void displayTree(Node node) {
        StringBuilder stringBuilder = new StringBuilder(node.data + " -> ");
        for (Node child : node.children) stringBuilder.append(child.data).append(", ");
        System.out.println(stringBuilder);
        for (Node child : node.children) displayTree(child);
    }
    public int sizeOfTree(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int ch = sizeOfTree(child);
            size = size + ch;
        }
        size++;
        return size;
    }
    public int maximumValue(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children)
            max = Math.max(maximumValue(child), max);
        max = Math.max(node.data, max);
        return max;
    }
    public int heightOfTree(Node node) {
        int height = 0;
        for (Node child : node.children)
            height = Math.max(heightOfTree(child), height);
        height++;
        return height;
    }
    public void treeTraversal(Node node) {
        System.out.println("Node pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Down " + node.data + " -> " + child.data);
            treeTraversal(child);
            System.out.println("Edge Up " + node.data + " <- " + child.data);
        }
        System.out.println("Node post " + node.data);
    }
    public void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size() > 0) {
            node = queue.remove();
            System.out.print(node.data + " - ");
            queue.addAll(node.children);
        }
    }
    public void printZigZagTraversal(Node node) {
        Stack<Node> mainStack = new Stack<>();
        mainStack.add(node);
        int level = 0;
        Stack<Node> childStack = new Stack<>();
        while (mainStack.size() > 0) {
            node = mainStack.pop();
            System.out.print(node.data + " ");
            if (level % 2  == 1) childStack.addAll(node.children);
            else for (int i = node.children.size() - 1; i >= 0; i--) childStack.add(node.children.get(i));
            if (mainStack.size() == 0) {
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
    public void mirrorOfTree(Node node) {
        for (Node child : node.children) mirrorOfTree(child);
        Collections.reverse(node.children);
    }
    public void removeLeaf(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) node.children.remove(child);
        }
        for (Node child : node.children) removeLeaf(child);
    }
    public void linearizeTree(Node node) {
        for (Node child : node.children) linearizeTree(child);
        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);    //remove last child.
            Node secondLast = node.children.get(node.children.size() - 1);          // get the second last child.
            while (secondLast.children.size() == 1) secondLast = secondLast.children.get(0); // get the leaf of second last child.
            secondLast.children.add(lastChild);             // add the last child to the leaf of second last child.
        }
    }
    public Node efficientLinearizeTree(Node node) {
        if (node.children.size() == 0) return node;
        Node lastTail = efficientLinearizeTree(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node lastChild = node.children.remove(node.children.size() - 1);    //remove last child.
            Node secondLast = node.children.get(node.children.size() - 1);          // get the second last child.
            Node secondLastTail = efficientLinearizeTree(secondLast);       // get the leaf of second last child.
            secondLastTail.children.add(lastChild);             // add the last child to the leaf of second last child.
        }
        return lastTail;
    }
    public boolean searchElement(Node node, int data) {
        if (node.data == data) return true;
        for (Node child : node.children) {
            boolean find = searchElement(child, data);
            if (find) return true;
        }
        return false;
    }
    public ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if(node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> pathToChild = nodeToRootPath(child, data);
            if (pathToChild.size() > 0) {
                pathToChild.add(node.data);
                return pathToChild;
            }
        }
        return new ArrayList<>();
    }
    public int lowestCommonAncestor(Node node, int data1, int data2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j))) {
            i--;
            j--;
        }
        return path1.get(i + 1);
    }
    public int distanceBetweenNodes(Node node, int data1, int data2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j))) {
            i--;
            j--;
        }
        i++;
        j++;
        return (i + j);
    }
    public boolean areTreeSimilar(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size())
            return false;
        for (int i = 0; i < node1.children.size() ; i++) {
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(i);
            if (!areTreeSimilar(child1, child2))
                return false;
        }
        return true;
    }
    public boolean areTreeMirrorImage(Node node1, Node node2) {
        if (node1.children.size() != node2.children.size())
            return false;
        for (int i = 0; i < node1.children.size() ; i++) {
            int j = node2.children.size() - 1 - i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);
            if (!areTreeMirrorImage(child1, child2))
                return false;
        }
        return true;
    }
    public boolean isTreeSymmetric(Node node) {
        return areTreeMirrorImage(node, node);
    }
    public void predecessorSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) state = 1;
            else predecessor = node;
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        for (Node child : node.children) predecessorSuccessor(child, data);
    }
    public void ceilAndFloor(Node node, int data) {
        if (node.data > data) if (node.data < ceil) ceil = node.data;
        if (node.data < data) if (node.data > floor) floor = node.data;
        for (Node child : node.children) ceilAndFloor(child, data);
    }
    public int KthLargestElement(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }
    public int nodeWithMaximumSubtreeSum(Node node) {
        int sum = 0;
        for (Node child : node.children) {
            int csm = nodeWithMaximumSubtreeSum(child);
            sum += csm;
        }
        sum = sum + node.data;
        if (sum > maxSum) {
            maxSumNode = node.data;
            maxSum = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        GenericTree genericTree = new GenericTree();
        genericTree.createTree(genericTree.array);
        genericTree.displayTree(genericTree.root);
        System.out.println(genericTree.sizeOfTree(genericTree.root));
        System.out.println(genericTree.maximumValue(genericTree.root));
        System.out.println(genericTree.heightOfTree(genericTree.root));
        System.out.println(genericTree.lowestCommonAncestor(genericTree.root, 110,80));
        System.out.println(genericTree.distanceBetweenNodes(genericTree.root, 70,110));
        System.out.println(genericTree.areTreeSimilar(genericTree.root, genericTree.root));
        System.out.println(genericTree.areTreeMirrorImage(genericTree.root, genericTree.root));
        System.out.println(genericTree.isTreeSymmetric(genericTree.root));
        System.out.println(genericTree.searchElement(genericTree.root, 80));
        System.out.println(genericTree.nodeToRootPath(genericTree.root,80));
        System.out.println(genericTree.KthLargestElement(genericTree.root, 3));
        genericTree.nodeWithMaximumSubtreeSum(genericTree.root);
        genericTree.predecessorSuccessor(genericTree.root, 90);
        genericTree.ceilAndFloor(genericTree.root, 65);
        genericTree.treeTraversal(genericTree.root);
        genericTree.levelOrderTraversal(genericTree.root);
        genericTree.printZigZagTraversal(genericTree.root);
        genericTree.mirrorOfTree(genericTree.root);
        genericTree.displayTree(genericTree.root);
        genericTree.removeLeaf(genericTree.root);
        genericTree.displayTree(genericTree.root);
        genericTree.linearizeTree(genericTree.root);
        genericTree.displayTree(genericTree.root);
        genericTree.efficientLinearizeTree(genericTree.root);
        genericTree.displayTree(genericTree.root);
        System.out.println(genericTree.predecessor.data + " " + genericTree.successor.data);
        System.out.println(genericTree.floor + " " + genericTree.ceil);
        System.out.println(genericTree.maxSum);
    }
}


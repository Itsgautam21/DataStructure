package dsa.tree;

import java.util.*;

class BinaryNode {

    public int data;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
/*                  10
                   /  \
                 20   30
                /    /  \
              40    50   60
 */

public class BinaryTree {

    static BinaryNode node = null;
    static Integer[] binaryTree = {10, 20 , 40, null, null, null, 30, 50, null, null, 60, null, null};
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> path = new ArrayList<>(); // for target path sum.
    static {
        for (int i  = binaryTree.length - 1 ; i >=0; i--) stack.add(binaryTree[i]);
    }
    public static BinaryNode createBinaryTree() {
        Integer data = stack.pop();
        if (data == null) return null;
        BinaryNode newNode = new BinaryNode(data, null, null);
        newNode.left = createBinaryTree();
        newNode.right = createBinaryTree();
        return newNode;
    }
    public static void preorder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    public static void inorder(BinaryNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + "  ");
            inorder(node.right);
        }
    }
    public static void postorder(BinaryNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + "  ");
        }
    }
    public static void displayTree(BinaryNode node) {
        if (node.left == null && node.right == null) {
            System.out.println(node.data + " -> No child");
            return;
        }
        String stringBuilder = node.data + " -> ";
        if (node.left != null) stringBuilder += node.left.data + ", ";
        if (node.right != null) stringBuilder += node.right.data + ", ";
        System.out.println(stringBuilder);
        if (node.left != null) displayTree(node.left);
        if (node.right != null) displayTree(node.right);
    }
    public static void levelOrderTraversal(BinaryNode node) {
        Queue<BinaryNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size() > 0) {
            BinaryNode remove = queue.remove();
            System.out.print(remove.data + " ->> ");
            if (remove.left != null) queue.add(remove.left);
            if (remove.right != null) queue.add(remove.right);
        }
    }
    public static int numberOfNodes(BinaryNode node) {
        int numberOfNodes = 0;
        if (node == null) return 0;
        numberOfNodes = numberOfNodes + numberOfNodes(node.left);
        numberOfNodes = numberOfNodes + numberOfNodes(node.right);
        numberOfNodes++;
        return numberOfNodes;
    }
    public static int sumOfNodes(BinaryNode node) {
        int sum = 0;
        if (node == null) return 0;
        sum = sum + sumOfNodes(node.left);
        sum = sum + sumOfNodes(node.right);
        sum = sum + node.data;
        return sum;
    }
    public static int maxValue(BinaryNode node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(maxValue(node.left), maxValue(node.right)));
    }
    public static int minValue(BinaryNode node) {
        if (node == null) return Integer.MAX_VALUE;
        int min = Math.min(minValue(node.left), minValue(node.right));
        min = Math.min(node.data, min);
        return min;
    }
    public static int heightOfTree(BinaryNode node) {
        if (node == null) return 0;
        int height = Math.max(heightOfTree(node.left), heightOfTree(node.right));
        height++;
        return height;
    }
    public static int targetPathSum(BinaryNode root, int targetSum) {
        if (root == null) return 0;
        path.add(root.data);
        int left = targetPathSum(root.left, targetSum);
        int right  = targetPathSum(root.right, targetSum);
        int count = 0;
        int sum = 0;
        for (int i = path.size() - 1; i >=0; i-- ) {
            sum = sum + path.get(i);
            if (sum == targetSum)
                count++;
        }
        path.remove(path.size() - 1);
        return left + right + count;
    }
    public static int maxPathSum(BinaryNode root, int targetSum) {
        if (root == null) return 0;
        path.add(root.data);
        int left = targetPathSum(root.left, targetSum);
        int right  = targetPathSum(root.right, targetSum);
        int sum = 0;
        for (int i = path.size() - 1; i >=0; i-- ) {
            sum = sum + path.get(i);
        }
        sum = Math.max(left, Math.max(right, sum));
        path.remove(path.size() - 1);
        return sum;
    }
    public static boolean searchTree(BinaryNode node, int value) {
        if (node == null) return false;
        if (node.data == value) {
            return true;
        }
        return searchTree(node.left, value) || searchTree(node.right, value);
    }
    public static ArrayList<Integer> nodeToRootPath(BinaryNode node, int value) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.data == value) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> path1 = nodeToRootPath(node.left, value);
        ArrayList<Integer> path2 = nodeToRootPath(node.right, value);
        if (path1.size() > 0) {
            path1.add(node.data);
            return path1;
        }
        if (path2.size() > 0) {
            path2.add(node.data);
            return path2;
        }
        return new ArrayList<>();
    }
    public static ArrayList<BinaryNode> nodeToRootPaths(BinaryNode node, int value) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.data == value) {
            ArrayList<BinaryNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        ArrayList<BinaryNode> path1 = nodeToRootPaths(node.left, value);
        ArrayList<BinaryNode> path2 = nodeToRootPaths(node.right, value);
        if (path1.size() > 0) {
            path1.add(node);
            return path1;
        }
        if (path2.size() > 0) {
            path2.add(node);
            return path2;
        }
        return new ArrayList<>();
    }
    public static ArrayList<Integer> rightSideView(BinaryNode root) {
        if(root == null)  return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<BinaryNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().data);
            while(size-- > 0) {
                BinaryNode rn = que.removeFirst();
                if(rn.right != null) que.addLast(rn.right);
                if(rn.left != null) que.addLast(rn.left);

            }
        }
        return ans;
    }
    public static ArrayList<Integer> leftSideView(BinaryNode root) {
        if(root == null)  return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<BinaryNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().data);
            while(size-- > 0) {
                BinaryNode rn = que.removeFirst();
                if(rn.left != null) que.addLast(rn.left);
                if(rn.right != null) que.addLast(rn.right);
            }
        }
        return ans;
    }
    public static void printKLevelDown(BinaryNode node, int k) {
        if (node == null || k < 0) return;
        if (k == 0) System.out.print(node.data + "  ");
        printKLevelDown(node.left, k - 1);
        printKLevelDown(node.right, k - 1);
    }
    public static void printKLevelDown(BinaryNode node, int k, BinaryNode blocker) {
        if (node == null || k < 0 || node == blocker) return;
        if (k == 0) System.out.print(node.data + " ->>> ");
        printKLevelDown(node.left, k - 1, blocker);
        printKLevelDown(node.right, k - 1, blocker);
    }
    public static void printKNodeFarNodes(BinaryNode node, int value, int k) {
        ArrayList<BinaryNode> path = nodeToRootPaths(node, value);
        for (int i = 0; i < path.size(); i++) {
            printKLevelDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
    }
    public static void printPathToLeafFromRoot(BinaryNode node, String path, int sum, int low, int high) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sum = sum + node.data;
            if (sum >= low && sum <= high) System.out.println(path + node.data);
            return;
        }
        printPathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, low, high);
        printPathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, low, high);
    }
    public static void printSingleChildNodes(BinaryNode node, BinaryNode parent) {
        if (node == null) return;
        if (parent != null && parent.left == node && parent.right == null) System.out.println(node.data);
        else if (parent != null && parent.right == node && parent.left == null) System.out.println(node.data);
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }
    public static void mirrorImage(BinaryNode node) {
        if (node == null) return;
        BinaryNode binaryNode;
        mirrorImage(node.left);
        mirrorImage(node.right);
        binaryNode = node.left;
        node.left = node.right;
        node.right = binaryNode;
    }
    public static BinaryNode removeLeaf(BinaryNode node) {
        if (node.left == null && node.right == null)
            return null;
        if (node.left != null)  node.left = removeLeaf(node.left);
        if (node.right != null) node.right = removeLeaf(node.right);
        return node;
    }
    public static BinaryNode createLeftClonedTree(BinaryNode node) {
        if (node == null) return null;
        BinaryNode leftNode = createLeftClonedTree(node.left);
        BinaryNode rightNode = createLeftClonedTree(node.right);
        node.left = new BinaryNode(node.data, leftNode, null);
        node.right = rightNode;
        return node;
    }
    public static BinaryNode createRightClonedTree(BinaryNode node) {
        if (node == null) return null;
        BinaryNode leftNode = createRightClonedTree(node.left);
        BinaryNode rightNode = createRightClonedTree(node.right);
        node.right = new BinaryNode(node.data, null, rightNode);
        node.left = leftNode;
        return node;
    }
    public static BinaryNode backFromLeftClonedTree(BinaryNode node) {
        if (node == null) return null;
        BinaryNode leftNode = backFromLeftClonedTree(node.left.left);
        BinaryNode rightNode = backFromLeftClonedTree(node.right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
    public static BinaryNode backFromRightClonedTree(BinaryNode node) {
        if (node == null) return null;
        BinaryNode leftNode = backFromRightClonedTree(node.left);
        BinaryNode rightNode = backFromRightClonedTree(node.right.right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public static void main(String[] args) {
        node = createBinaryTree();
        System.out.println("Display DataStructures.Tree : ");
        displayTree(node);
        System.out.print("Preorder : ");
        preorder(node);
        System.out.print("\n"+"Inorder : ");
        inorder(node);
        System.out.print("\n"+"Postorder : ");
        postorder(node);
        System.out.print("\n" + "Level order Traversal : ");
        levelOrderTraversal(node);
        System.out.print("\n" + "Print K Level Down : ");
        printKLevelDown(node, 2);
        System.out.print("\n" + "Print K Node Far Nodes : ");
        printKNodeFarNodes(node, 30, 1);
        System.out.print("\n" + "Print Path to leaf from Root : ");
        printPathToLeafFromRoot(node, "", 0, 10, 100);
        System.out.print("Print Single child Nodes : ");
        printSingleChildNodes(node, null);
        System.out.println("Right side view : " + rightSideView(node));
        System.out.println("Right side view : " + leftSideView(node));
        System.out.println("Number of Nodes : " + numberOfNodes(node));
        System.out.println("Sum of Nodes : " + sumOfNodes(node));
        System.out.println("Maximum value : " + maxValue(node));
        System.out.println("Minimum value : " + minValue(node));
        System.out.println("Height of DataStructures.Tree : " + heightOfTree(node));
        System.out.println("Search element : " + searchTree(node,10));
        System.out.println("Node to root Path : " + nodeToRootPath(node, 60));
        System.out.println("Target Path Sum : " + targetPathSum(node, 70));
        //displayTree(createLeftClonedTree(node));System.out.println();
        //displayTree(createRightClonedTree(node));
        //displayTree(backFromLeftClonedTree(node));
        //displayTree(backFromRightClonedTree(node));
    }
}

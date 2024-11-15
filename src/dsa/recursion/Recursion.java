package dsa.recursion;

import java.util.*;

public class Recursion {

    static String[] code = {",.", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
    int[] targetSumSubset = {10, 20, 30, 40, 50};
    int[] arr = {1, 2, 3, 4, 3, 4, 3, 6, 3, 8, 9};
    int[][] NQueen = new int[5][5];
    int[][] floodFill = {{0, 1, 1},
            {0, 0, 1},
            {1, 0, 0},
            {0, 1, 0}};
    boolean[][] vi = new boolean[4][3];

    public static void increase(int n) {
        if (n == 0) return;
        increase(n-1);
        System.out.print(n+"\t");
    }
    public static void decrease(int n) {
        if (n == 0) return;
        System.out.print(n+"\t");
        decrease(n-1);
    }
    public static void decreaseIncrease(int n) {
        if (n == 0) return;
        System.out.print(n+"\t");
        decreaseIncrease(n-1);
        System.out.print(n+"\t");
    }
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n*factorial(n-1);
    }
    public static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x,n-1);
    }
    public static int powerLog(int x, int n) {
        if (n == 0) return 1;
        int xn =  powerLog(x, (n/2)) * powerLog(x, n/2);
        if (n % 2 == 1) xn = xn * x;
        return xn;
    }
    public static void multipleRecursion(int n) {
        if (n == 0) return;
        System.out.println("Pre" + n);
        multipleRecursion(n-1);
        System.out.println("In" + n);
        multipleRecursion(n-1);
        System.out.println("Post" + n);
    }
    public static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 0) return;
        towerOfHanoi(n - 1, a, c, b);
        System.out.println(n +" ko "+ a + " -> " + b);
        towerOfHanoi(n - 1, c, b, a);
    }
    public static void printArray(int[] arr, int n) {
        if (n == -1) return;
        printArray(arr, (n-1));
        System.out.print(arr[n]+ "\t");
    }
    public static void reverseArray(int[] arr, int n) {
        if (n == -1) return;
        System.out.print(arr[n]+ "\t");
        reverseArray(arr, (n-1));
    }
    public static int maxValue(int[] arr, int n) {
        if (arr.length-1 == n) return arr[n];
        return Math.max(maxValue(arr, n+1), arr[n]);
    }
    public static int firstIndex(int[] arr, int n, int x) {
        if (n == arr.length) return -1;
        if (arr[n] == x) return n;
        else return firstIndex(arr, n+1, x);
    }
    public static int lastIndex(int[] arr, int n, int x) {
        if (n == arr.length) return -1;
        if (lastIndex(arr, n+1, x) == -1) {
            if (arr[n] == x) return n;
            else return -1;
        } else return lastIndex(arr, n+1, x);
    }
    public static ArrayList<Integer> allIndex(int[] arr, int n, int x) {
        if (n == arr.length) return new ArrayList<>();
        if (arr[n] == x) {
            ArrayList<Integer> result = allIndex(arr, n+1, x); // My Faith..
            result.add(n);
            //result[fsf] = n;
            return result;
        }
        else return allIndex(arr, n+1, x);
    }
    public static ArrayList<String> subSequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        char ch = str.charAt(0);
        String sub = str.substring(1);
        ArrayList<String> strings = subSequence(sub);

        ArrayList<String> result = new ArrayList<>();
        for (String value : strings)
            result.add("" + value);
        for (String value : strings)
            result.add(ch + value);
        return result;
    }
    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        char ch = str.charAt(0);
        String sub = str.substring(1);

        ArrayList<String> result = getKPC(sub);

        ArrayList<String> arrayList = new ArrayList<>();
        String arrayValue = code[ch - '0'];
        for (int i = 0; i < arrayValue.length(); i++) {
            char arrayChar = arrayValue.charAt(i);
            for (String value : result) {
                arrayList.add(arrayChar + value);
            }
        }
        return arrayList;
    }
    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> Empty = new ArrayList<>();
            Empty.add("");
            return Empty;
        } else if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> paths1 = getStairPaths(n - 1);
        ArrayList<String> paths2 = getStairPaths(n - 2);
        ArrayList<String> paths3 = getStairPaths(n - 3);

        ArrayList<String> paths = new ArrayList<>();
        for (String path : paths1) paths.add(1 + path);
        for (String path : paths2) paths.add(2 + path);
        for (String path : paths3) paths.add(3 + path);
        return paths;
    }
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();
        if (sr < dr) hPaths = getMazePaths(sr + 1, sc, dr, dc);
        if (sc < dc) vPaths = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> paths = new ArrayList<>();
        for (String path : hPaths) paths.add("h" + path);
        for (String path : vPaths) paths.add("v" + path);
        return paths;
    }
    public static void printSubSequence(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + "\t");
            return;
        }
        char ch = str.charAt(0);
        String substring = str.substring(1);
        printSubSequence(substring,ans + ch);
        printSubSequence(substring,ans + "");

    }
    public static void printGetKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + "\t");
            return;
        }
        char ch = str.charAt(0);
        String sub = str.substring(1);
        String arrayValue = code[ch - '0'];
        for (int i = 0; i < arrayValue.length(); i++) {
            char arrayChar = arrayValue.charAt(i);
            printGetKPC(sub, ans + arrayChar);
        }
    }
    public static void printStairPaths(int n, String ans) {
        if (n == 0) {
            System.out.print(ans+ "\t");
            return;
        } else if (n < 0) return;
        printStairPaths(n-1, ans + 1);
        printStairPaths(n-2, ans + 2);
        printStairPaths(n-3, ans + 3);
    }
    public static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.print(ans + ", ");
            return;
        }
        if (sr > dr || sc > dc) return;
        printMazePaths(sr + 1, sc, dr, dc, ans + "h");
        printMazePaths(sr, sc + 1, dr, dc, ans + "v");
    }
    public static void printPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + ", ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String sub1 = str.substring(i+1);
            String sub2 = str.substring(0, i);
            printPermutation(sub1+sub2, ans + ch);
        }
    }
    public static void printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + ", ");
            //return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') { System.out.println();}
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                ans = ans + code;
                System.out.print(ans + ", ");
            }
        } else {
            char ch = str.charAt(0);
            String sub = str.substring(1);
            if (ch == '0') return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncodings(sub, ans + code);
            }
            String ch12 = str.substring(0, 2);
            String sub12 = str.substring(1);
            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncodings(sub12, ans + code);
            }
        }
    }
    public static void printFloodFill(int[][] arr, int row, int col, String ans, boolean[][] visited) {
        if (row < 0 || col < 0 || arr.length == row || arr[0].length == col || arr[row][col] == 1 || visited[row][col]) return;
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.print(ans + ", ");
            return;
        }
        visited[row][col] = true;
        printFloodFill(arr, row - 1, col, ans + "Top -> ", visited);
        printFloodFill(arr, row, col - 1, ans + "Left -> ", visited);
        printFloodFill(arr, row + 1, col, ans + "Down -> ", visited);
        printFloodFill(arr, row, col + 1, ans + "Right -> ", visited);
        visited[row][col] = false;
    }
    public static void printTargetSumSubset(int[] arr, int n, int sos, String ans, int target) {
        if (n == arr.length) {
            if (sos == target) {
                System.out.println(ans);
            }
            return;
        }
        printTargetSumSubset(arr, n +1 , sos + arr[n] , ans + arr[n] + ", ", target);
        printTargetSumSubset(arr, n +1 , sos , ans, target);
    }
    public static void printNQueens(int[][] chess, String ans, int row) {
        if (row == chess.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (chess[row][col] == 0 && isItaSafePlaceForQueen(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, ans + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    public static void printKnightTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) return;
        else if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        printKnightTour(chess, row - 2, col + 1, move + 1);
        printKnightTour(chess, row - 1, col + 2, move + 1);
        printKnightTour(chess, row + 1, col + 2, move + 1);
        printKnightTour(chess, row + 2, col + 1, move + 1);
        printKnightTour(chess, row + 2, col - 1, move + 1);
        printKnightTour(chess, row + 1, col - 2, move + 1);
        printKnightTour(chess, row - 1, col - 2, move + 1);
        printKnightTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }
    public static void displayBoard(int[][] chess) {
        for (int[] ints : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isItaSafePlaceForQueen(int[][] chess, int row, int col) {
        for (int i = row - 1; i >= 0; i--) if (chess[i][col] == 1) return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (chess[i][j] == 1) return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) if (chess[i][j] == 1) return false;
        return true;
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        increase(5);
        System.out.println();
        decrease(5);
        System.out.println();
        decreaseIncrease(5);
        System.out.println("\n" + factorial(5));
        System.out.println(power(10,8));
        System.out.println(powerLog(10,8));
        multipleRecursion(3);
        towerOfHanoi(3, 'A','B','C');
        printArray(recursion.arr, (recursion.arr.length - 1));
        System.out.println();
        reverseArray(recursion.arr, (recursion.arr.length - 1));
        System.out.println();
        System.out.println(maxValue(recursion.arr, 0));
        System.out.println(firstIndex(recursion.arr, 0, 3));
        System.out.println(lastIndex(recursion.arr, 0, 3));
        System.out.println(allIndex(recursion.arr, 0, 3));
        System.out.println(subSequence("abc"));
        System.out.println(getKPC("67"));
        System.out.println(getStairPaths(4));
        System.out.println(getMazePaths(1,1,3,3));
        printSubSequence("abc", "");
        System.out.println();
        printGetKPC("67", "");
        System.out.println();
        printStairPaths(4, "");
        System.out.println();
        printMazePaths(1,1,3,3,"");
        System.out.println();
        printPermutation("abc", "");
        System.out.println();
        printEncodings("123", "");
        System.out.println();
        printFloodFill(recursion.floodFill,0,0,"", recursion.vi);
        System.out.println();
        printTargetSumSubset(recursion.targetSumSubset,0, 0, "", 60);
        System.out.println();
        printNQueens(recursion.NQueen, "",0);
        printKnightTour(recursion.NQueen, 2,0,1);
    }
}


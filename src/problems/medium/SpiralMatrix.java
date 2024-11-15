package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 54
 */
public class SpiralMatrix {

    /**
     * get all edges of matrix
     *
     * @param matrix  m * n matrix
     * @param list    store edge elements of matrix
     * @param visited visited array
     */
    public static void getEdgeElements(int[][] matrix, List<Integer> list, boolean[][] visited) {
        int row = 0;
        int col = 0;
        /// move right from start on matrix
        while (col < matrix[0].length) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            col++;
        }
        col--;
        row++;
        /// move down after right on matrix
        while (row < matrix.length) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            row++;
        }
        row--;
        col--;
        /// move left after down on matrix
        boolean isBack = false;
        if (row > 0) {
            while (col >= 0) {
                visited[row][col] = true;
                list.add(matrix[row][col]);
                col--;
                isBack = true;
            }
        }
        col++;
        row--;
        /// move top on matrix after left
        /// and stop before the last element
        if (isBack) {
            while (row > 0) {
                visited[row][col] = true;
                list.add(matrix[row][col]);
                row--;
            }
        }
    }
    /**
     * get all edges of matrix (optimise)
     *
     * @param matrix  m * n matrix
     * @param list    store edge elements of matrix
     * @param visited visited array
     */
    public static void getEdgesElementsM2(int[][] matrix, boolean[][] visited, List<Integer> list) {

        int row = 0;
        int col = 0;
        /// if the matrix is 1D.

        // if matrix is a row matrix then
        // add all elements of the that row and return
        if (matrix.length == 1) {
            while (col < matrix[0].length) {
                visited[row][col] = true;
                list.add(matrix[row][col]);
                col++;
            }
            return;
        }
        // if matrix is a column matrix then
        // add all elements of that column and return
        if (matrix[0].length == 1) {
            while (row < matrix.length) {
                visited[row][col] = true;
                list.add(matrix[row][col]);
                row++;
            }
            return;
        }
        /// if the matrix is 2D

        // move towards right on the edge of matrix
        // and stop before the last element.
        while (col < matrix[0].length - 1) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            col++;
        }
        // move towards down on the edge of matrix
        // and stop before the last element.
        while (row < matrix.length - 1) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            row++;
        }
        // move towards left on the edge of matrix
        // and stop before the last element.
        while (col > 0) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            col--;
        }
        // move towards up on the edge of matrix
        // and stop before the last element.
        while (row > 0) {
            visited[row][col] = true;
            list.add(matrix[row][col]);
            row--;
        }
    }

    /**
     * print elements in spiral traversal.
     *
     * @param matrix  matrix
     * @param list    list to store elements
     * @param visited visited array
     */
    public static void spiralMatrix(int[][] matrix, boolean[][] visited, List<Integer> list) {

        getEdgesElementsM2(matrix, visited, list);
        // create a new length for new matrix.
        // new length of row and column is always 2 less than
        // from previous matrix's row and column length respectively.
        int subROW = matrix.length - 2;
        int subCOLUMN = matrix[0].length - 2;

        // if the length of row or column is
        // less than one then it's not a valid matrix.
        if (subROW < 1 || subCOLUMN < 1) {
            return;
        }
        int[][] subMatrix = new int[subROW][subCOLUMN];
        boolean[][] subVisited = new boolean[subROW][subCOLUMN];

        // create a sub matrix with not visited elements of previous matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    subMatrix[i - 1][j - 1] = matrix[i][j];
                }
            }
        }
        // recursive call for sub matrix.
        spiralMatrix(subMatrix, subVisited, list);
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        spiralMatrix(matrix, visited, list);
        return list;
    }

    public static void main(String[] args) {

        int[][] rowMatrix = {{1, 2, 3}};
        int[][] columnMatrix = {
                {1},
                {2},
                {3}};
        int[][] threeThreeMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] fourThreeMatrix = {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21}};
        int[][] fourFiveMatrix = {
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29}};
        int[][] fiveFiveMatrix = {
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34}};

        System.out.println(spiralMatrix(rowMatrix));
        System.out.println(spiralMatrix(columnMatrix));
        System.out.println(spiralMatrix(threeThreeMatrix));
        System.out.println(spiralMatrix(fourThreeMatrix));
        System.out.println(spiralMatrix(fourFiveMatrix));
        System.out.println(spiralMatrix(fiveFiveMatrix));
    }
}

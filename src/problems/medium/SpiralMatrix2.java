package problems.medium;

import java.util.Arrays;

/**
 * @Question : 59
 */
public class SpiralMatrix2 {

    public static int traverseEdgeElements(int[][] matrix, int row, int col, int boundary, int value) {

        // move towards right on the edge of matrix
        // and stop before the last element.
        while(col < matrix[0].length - 1 - boundary) {
            matrix[row][col] = ++value;
            col++;
        }
        // move towards down on the edge of matrix
        // and stop before the last element.
        while(row < matrix.length - 1 - boundary) {
            matrix[row][col] = ++value;
            row++;
        }
        // move towards left on the edge of matrix
        // and stop before the last element.
        while(col > boundary) {
            matrix[row][col] = ++value;
            col--;
        }
        // move towards up on the edge of matrix
        // and stop before the last element.
        while(row > boundary) {
            matrix[row][col] = ++value;
            row--;
        }
        return value;
    }

    public static int[][] generateSpiralMatrix2(int length) {

        int[][] matrix = new int[length][length];
        int value = 0;
        // traverse through the edge of every sub matrix,
        // max traversal is half of the matrix's length.
        for (int i = 0; i < length / 2; i++) {
            value = traverseEdgeElements(matrix, i, i, i, value);
        }
        // if matrix's dimension is odd then
        // fill the centre value manually
        if (length % 2 != 0) {
            matrix[length / 2][length / 2] = ++value;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateSpiralMatrix2(3)));
        System.out.println(Arrays.deepToString(generateSpiralMatrix2(4)));
        System.out.println(Arrays.deepToString(generateSpiralMatrix2(5)));
    }
}

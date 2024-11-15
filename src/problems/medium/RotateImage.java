package problems.medium;

import java.util.Arrays;

/**
 * @Question : 48
 */
public class RotateImage {

    private static void reverseColumn(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix.length - 1;
            while (start < end) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }
    }

    private static void transposeMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void rotateImage(int[][] matrix) {
        reverseColumn(matrix);
        transposeMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

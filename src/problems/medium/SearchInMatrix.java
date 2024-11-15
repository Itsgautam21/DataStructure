package problems.medium;

/**
 * @Question : 74
 */
public class SearchInMatrix {

    private static int binarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target)
                return array[mid];
            else if (array[mid] < target) {
                start = mid + 1;
            } else end = mid - 1;
        }
        if (target > array[0]) return -1;
        else return -2;
    }

    /**
     * search elements in matrix O(log(m) * log(n))
     *
     * @param matrix matrix
     * @param target target
     * @return elements present or not
     */
    private static boolean searchInMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = binarySearch(matrix[mid], target);
            if (result == target) {
                return true;
            } else if (result == -1) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return false;
    }

    /**
     * search element in matrix O(m + n)
     *
     * @param matrix matrix
     * @param target target
     * @return elements present or not
     */
    private static boolean searchInMatrixM2(int[][] matrix, int target) {

        int start = 0;
        int end = matrix[0].length - 1;
        while (start < matrix.length && end >= 0) {
            if (matrix[start][end] == target) return true;
            else if (matrix[start][end] < target) start++;
            else end--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(searchInMatrix(matrix, 30));
        System.out.println(searchInMatrixM2(matrix, 30));
    }
}
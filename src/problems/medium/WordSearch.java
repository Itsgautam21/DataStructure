package problems.medium;

/**
 * @Question : 79
 */
public class WordSearch {

    private static boolean wordSearch(char[][] board, int row, int col, String word, int wordLength, boolean[][] visited) {

        if (wordLength == word.length()) return true;
        if (row == board.length || row < 0 || col < 0 || col == board[0].length || visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(wordLength)) return false;

        visited[row][col] = true;
        boolean rightMove = wordSearch(board, row, col + 1, word, wordLength + 1, visited);
        boolean downMove = wordSearch(board, row + 1, col, word, wordLength + 1, visited);
        boolean leftMove = wordSearch(board, row, col - 1, word, wordLength + 1, visited);
        boolean topMove = wordSearch(board, row - 1, col, word, wordLength + 1, visited);
        visited[row][col] = false;
        return rightMove || downMove || leftMove || topMove;
    }

    private static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (wordSearch(board, row, col, word, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(matrix, "ASAD"));
        System.out.println(exist(matrix, "SEE"));
        System.out.println(exist(matrix, "ABCS"));
    }
}

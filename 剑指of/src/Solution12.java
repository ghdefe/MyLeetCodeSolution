/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * Copy to clipboardErrorCopied
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符 b 占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * Copy to clipboardErrorCopied
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */

class Solution12 {
    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        int rows = board.length, cols = board[0].length;
        this.rows = rows;
        this.cols = cols;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visit(board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean visit(char[][] board, String word, int i, int j, boolean[][] visited) {
        if (word.length() == 0)
            return true;
        if (i < 0 || j < 0 || i >= rows || j >= cols || word.charAt(0) != board[i][j] || visited[i][j])
            return false;

        visited[i][j] = true;       //标记已使用
        String subWord = word.substring(1);
        boolean b1 = visit(board, subWord, i, j + 1, visited);
        boolean b2 = visit(board, subWord, i, j - 1, visited);
        boolean b3 = visit(board, subWord, i + 1, j, visited);
        boolean b4 = visit(board, subWord, i - 1, j, visited);
        boolean res = (b1 || b2 || b3 || b4);
        visited[i][j] = res;      //还原已使用
        return res;
    }
}

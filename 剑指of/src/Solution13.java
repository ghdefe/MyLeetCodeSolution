/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为 3+5+3+7=18。但它不能进入方格 [35, 38]，因为 3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * Copy to clipboardErrorCopied
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
class Solution13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        visit(0, 0, k, m, n, visited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += visited[i][j] ? 1 : 0;
            }
        }
        return count;
    }

    void visit(int i, int j, int k, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return;
        if (sum(i, j) <= k) {
            visited[i][j] = true;
            visit(i, j + 1, k, m, n, visited);
            visit(i, j - 1, k, m, n, visited);
            visit(i + 1, j, k, m, n, visited);
            visit(i - 1, j, k, m, n, visited);
        }
    }

    static int sum(int i, int j) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i /= 10;
        }

        while (j > 0) {
            res += j % 10;
            j /= 10;
        }
        return res;
    }

//    public static void main(String[] args) {
//        int i = new Solution13().movingCount(1, 2, 1);
//        System.out.println(i);
//    }
}

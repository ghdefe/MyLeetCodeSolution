import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.Stack;

/**
 * 边界弄死
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * Copy to clipboardErrorCopied
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution29 {
    enum flag {
        UP,
        DOWN,
        left,
        right
    }

    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        flag now = flag.right;
        int i = 0, j = 0;
        int[] res = new int[(rows) * (cols)];
        int k = 0;
        while (true) {
                res[k++] = matrix[i][j];
                if (now == flag.right ) {
                    visited[i][j] = true;
                    j++;
                    if (j >= cols || visited[i][j]){
                        j--;
                        i++;
                        now = flag.DOWN;
                        if (i >= rows || i < 0 || j>=cols || j<0 ||visited[i][j])
                            break;
                    }
                }

                else if(now == flag.DOWN){
                    visited[i][j] = true;
                    i++;
                    if (i >= rows || i < 0 || j>=cols || j<0 ||visited[i][j])
                        i--;
                        --j;
                        now = flag.left;
                        if (visited[i][j])
                            break;
                    }

                else if(now == flag.left){
                    visited[i][j] = true;
                    j--;
                    if (j < 0 || visited[i][j]){
                        j++;
                        --i;
                        now = flag.UP;
                        if (i >= rows || i < 0 || j>=cols || j<0 ||visited[i][j])
                            break;
                    }
                }

                else if(now == flag.UP){
                    visited[i][j] = true;
                    i--;
                    if (j < 0 || visited[i][j]){
                        i++;
                        ++j;
                        now = flag.right;
                        if (i >= rows || i < 0 || j>=cols || j<0 ||visited[i][j])
                            break;
                    }
                }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = new Solution29().spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));
    }


}


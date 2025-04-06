import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        new Solution().exist(board, "ABCB");
    }
}


class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    boolean[][] visit;
    boolean res;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] array = word.toCharArray();
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    DFS(board, array, i, j, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void DFS(char[][] board, char[] word, int i, int j, int idx) {
        if (idx+1 == word.length) {
            res=true;
            return;
        }
        visit[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int tx = i + x[k];
            int ty = j + y[k];
            if (tx >= 0 && tx < board.length
                    && ty >= 0 && ty < board[0].length
                    && !visit[tx][ty]
                    && board[tx][ty] == word[idx+1]) {
                DFS(board, word, tx, ty, idx + 1);
            }
        }
        visit[i][j]=false;
    }
}
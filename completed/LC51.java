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
        new Solution().solveNQueens(1);
    }
}


class Solution {
    char[][] tmp;
    int n;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        tmp = new char[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = '.';
            }
        }
        rec(0);
        return ans;
    }

    void rec(int level) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = new String(tmp[i]);
                list.add(str);
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isLegal(level, i)) {
                tmp[level][i] = 'Q';
                rec(level + 1);
                tmp[level][i] = '.';
            }
        }
    }

    boolean isLegal(int i, int j) {
        for (int k = 0; k < n; k++) {
            if (tmp[k][j] == 'Q' || tmp[i][k] == 'Q') {
                return false;
            }
        }
        int a = i - 1, b = j - 1;
        while (a >= 0 && b >= 0) {
            if (tmp[a][b] == 'Q') {
                return false;
            }
            a--;
            b--;
        }
        a = i + 1;
        b = j + 1;
        while (a < n && b < n) {
            if (tmp[a][b] == 'Q') {
                return false;
            }
            a++;
            b++;
        }
        a = i + 1;
        b = j - 1;
        while (a < n && b >= 0) {
            if (tmp[a][b] == 'Q') {
                return false;
            }
            a++;
            b--;
        }
        a = i - 1;
        b = j + 1;
        while (a >= 0 && b < n) {
            if (tmp[a][b] == 'Q') {
                return false;
            }
            a--;
            b++;
        }
        return true;
    }
}
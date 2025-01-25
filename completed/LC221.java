//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };
//        char[][] matrix = {
//                {'0','1'},{
//                    '1','0'
//        }
//        };
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        new Solution().maximalSquare(matrix);
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                } else {
                    dp[i][j] = matrix[i][j] - '0';
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans * ans;
    }
}
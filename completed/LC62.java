//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

        String s = new Solution().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.printf(s);
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] += i-1>=0?dp[i-1][j]:0;
                dp[i][j] += j-1>=0?dp[i][j-1]:0;
            }
        }
        return dp[m-1][n-1];
    }
}
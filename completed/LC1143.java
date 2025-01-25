//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        new Solution().longestCommonSubsequence("abcde", "ace");
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = str1[i - 1] == str2[j - 1] ? dp[i-1][j-1] + 1 : Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
//        for (int i = 0; i <= len1; i++) {
//            for (int j = 0; j <= len2; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[len1][len2];
    }
}
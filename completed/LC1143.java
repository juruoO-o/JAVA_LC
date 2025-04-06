//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import javax.swing.*;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class LC {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2, 4};
        new Solution().longestCommonSubsequence("abcde","ace");

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = arr1[i-1]==arr2[j-1]?dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
}
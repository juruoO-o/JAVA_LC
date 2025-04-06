//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import javax.swing.*;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class LC {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2, 4};
        new Solution().beautifulSubarrays(nums);

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
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = nums1[i] == nums2[j] ? 1 : 0;
                }
                else{
                    dp[i][j] =nums1[i] == nums2[j] ? dp[i-1][j-1]+1 : 0;
//                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
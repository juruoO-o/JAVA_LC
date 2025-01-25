
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 2, 3, 4
                }, {
                5, 6, 7, 8
        }, {
                9, 10, 11, 12
        }
        };
        new Solution().spiralOrder(matrix);

    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
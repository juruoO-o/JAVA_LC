//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.constantpool.NameAndTypeEntry;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,5}, nums2 = {2, 7};
        new Solution().coinChange(nums1,11);
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; ++i) {
            dp[i] = 1000000;
            for (int coin : coins) {
                if(coin>i)
                    continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        if(dp[amount]==1000000)
            return -1;
        else
            return dp[amount];
    }
}
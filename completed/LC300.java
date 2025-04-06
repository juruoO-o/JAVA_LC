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
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans=0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans =Math.max(ans,dp[i]);
        }
        return ans;
    }
}
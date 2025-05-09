import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().minTimeToReach(new int[][]{
                {0, 58}, {27, 69}
        });
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = -1;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
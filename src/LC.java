import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {
                -1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {2, 2, 3, 5};
        new Solution().canPartition(nums);

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
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int acc = 0;
        for (int i = 0; i < len; i++) {
            acc += nums[i];
        }
        if (acc % 2 != 0) {
            return false;
        }
        int target = acc >> 1;
        boolean[][] dp = new boolean[len][target + 1];
        if (nums[0]>target)
            return false;
        dp[0][0] = dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if(num>target)
                return false;
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i-1][j] || (j>=num ? dp[i-1][j-num]:false);
            }
        }
        return dp[len-1][target];
    }
}
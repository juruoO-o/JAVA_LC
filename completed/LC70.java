import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        double res = new Solution().countInterestingSubarrays(List.of(3,1,9,6),3,0);

    }
}


class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[0]=1;
        for (int i = 2; i < n + 1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {1,0,1,0,1};
        new Solution().findLength(nums1, nums2);
        System.out.println();
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
                } else {
                    dp[i][j] =nums1[i] == nums2[j] ? dp[i-1][j-1]+1 : 0;
//                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
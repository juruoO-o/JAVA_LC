//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {0, 1, 1, 1, 1};
        int[] nums2 = {1,2};
        new Solution().rob(nums2);
        System.out.println();
    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if(i==0){
                dp[0] = nums[0];
            } else if (i == 1) {
                dp[i] = Math.max(nums[1],nums[0]);
            } else{
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
        }
        return dp[len-1];
    }
}
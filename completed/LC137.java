import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().singleNumber(new int[]{2,2,3,2});

    }
}


class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] bit = new int[32];
        for(int num:nums){
            for (int i = 0; i < 32; i++) {
                if ((num&1) ==1){
                    bit[i]++;
                }
                num>>>=1;
            }
        }
        for (int i = 31; i >=0 ; i--) {
            ans<<=1;
            ans+=bit[i]%3;
        }
        return ans;
    }
}
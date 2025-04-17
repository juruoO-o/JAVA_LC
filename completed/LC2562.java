import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().countPairs(new int[]{3,1,2,2,2,1,3},2);

    }
}


class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            ans+= Integer.parseInt(nums[i]+""+nums[len-i-1]);
        }
        if (len%2==1){
            ans+=nums[len/2];
        }
        return ans;
    }
}
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
    public int countSubarrays(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length - 2; i++) {
            if(((nums[i]+nums[i+2])<<1) == nums[i+1]){
                ans++;
            }
        }
        return ans;
    }
}
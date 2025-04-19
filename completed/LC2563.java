import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution();

    }
}


class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
             int idx1 = lower_bound(nums,i+1, nums.length-1, lower-nums[i]);
             int idx2 = lower_bound(nums,i+1, nums.length-1, upper-nums[i]+1);
             ans+=idx2-idx1;
        }
        return ans;
    }

    int lower_bound(int[] nums, int left, int right, int target) {
        int mid;
        while (left<right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
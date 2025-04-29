import java.util.*;
import java.util.List;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().countSubarrays(new int[]{1,3,2,3,3}, 2);

    }
}


class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                cnt.add(i);
            } else if (nums[i] > max) {
                cnt.clear();
                cnt.add(-1);
                cnt.add(i);
                max = nums[i];
            }
        }
        long ans = 0;
        int len = nums.length;
        for (int i = k; i < cnt.size(); i++) {
            ans += (long) (len - cnt.get(i) ) * (cnt.get(i-k+1)-cnt.get(i-k));
        }
        return ans;
    }
}
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        double res = new Solution().countCompleteSubarrays(new int[]{1,3,1,2,2});

    }
}


class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int unique = set.size();
        int len = nums.length;
        int ans=0;
        for (int i = 0; i <= len - unique; i++) {
            set.clear();
            for (int j = i; j < len; j++) {
                set.add(nums[j]);
                if (set.size()==unique){
                    ans++;
                }else if (set.size()>unique){
                    break;
                }
            }
        }
        return ans;
    }
}
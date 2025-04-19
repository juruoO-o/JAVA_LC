import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().decodeString("3[a2[c]]");

    }
}


class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i] - i, 0);
            map.put(nums[i] - i, map.get(nums[i] - i) + 1);
        }
        long ans=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans+= (long) entry.getValue() * (nums.length-entry.getValue());
        }
        return ans/2;
    }
}
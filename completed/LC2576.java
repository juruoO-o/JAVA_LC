import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {
                -1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {3, 5, 2, 4};
        new Solution().maxNumOfMarkedIndices(nums);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int halfLen = len >> 1;
        int left = 0, right = halfLen;
        int ans = 0;
        while (left < halfLen && right < len) {
            if ((nums[left] << 1) <= nums[right]) {
                left++;
                right++;
                ans += 2;
            } else {
                right++;
            }
        }
        return ans;
    }
}

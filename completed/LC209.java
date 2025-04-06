import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 87, 87, 87, 2, 1};

        new Solution().isSubsequence("axc", "ahbgdc");
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int ans = (int) 1e9;
        int sum = 0;
        while (right < nums.length) {
            while (right < nums.length&&sum < target) {
                sum += nums[right];
                right++;
            }
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return ans == 1e9?0:ans;
    }
}
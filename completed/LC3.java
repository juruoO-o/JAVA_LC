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

        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fast = 0, slow = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        int[] cnt = new int[128];
        while (fast < len) {
            cnt[arr[fast]]++;
            while (cnt[arr[fast]] > 1) {
                cnt[arr[slow]]--;
                slow++;
            }
            fast++;
            ans = Math.max(ans, fast - slow);
        }
        return ans;
    }
}
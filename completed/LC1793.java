import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.management.ListenerNotFoundException;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
import java.nio.charset.StandardCharsets;
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
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {2, 5};
        List<String> strs = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        new Solution().ladderLength("hit", "cog", strs);
    }
}

class Solution {
    public int maximumScore(int[] nums, int k) {
        int len = nums.length;
        int min = nums[k];
        int ans = 0;
        int left = k - 1, right = k + 1;
        while (true) {
            while (left >= 0 && nums[left] >= min) {
                left--;
            }
            while (right < len && nums[right] >= min) {
                right++;
            }
            ans = Math.max(ans, min * (right - left - 1));
            if (left<0 && right>=len)
                break;
            min = Math.max(left==-1?-1:nums[left], right==len?-1:nums[right]);
        }
        return ans;
    }
}
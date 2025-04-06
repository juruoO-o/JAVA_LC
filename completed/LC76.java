import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
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
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 87, 87, 87, 2, 1};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().findSubstring("wordgoodgoodgoodbestword", strs);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        String ans = "";
        int minLen = (int) (1e9);
        int unique = 0;
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                unique++;
            }
            cnt[c]++;
        }
        int left = 0, right = 0;
        int sLen = s.length();
        while (right < sLen) {
            while (unique > 0 && right < sLen) {
                char c = s.charAt(right);
                cnt[c]--;
                if (cnt[c] == 0) {
                    unique--;
                }
                right++;
            }
            while (unique == 0) {
                char c = s.charAt(left);
                cnt[c]++;
                if (cnt[c] > 0) {
                    unique++;
                }
                left++;
            }
            if (left>0) {
                int len = right - left+1;
                if (len < minLen) {
                    minLen = len;
                    ans = s.substring(left-1, right);
                }
            }
        }
        return ans;
    }
}
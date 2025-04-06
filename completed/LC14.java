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

        new Solution().intToRoman(3749);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            len = Math.min(prefix(strs[0],strs[i]),len);
        }
        return strs[0].substring(0,len);
    }

    private int prefix(String str1, String str2) {
        int len = Math.min(str1.length(),str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i)!=str2.charAt(i)){
                return i;
            }
        }
        return len;
    }
}
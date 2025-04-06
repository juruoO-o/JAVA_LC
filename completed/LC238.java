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
        int[] height = {5, 2, 3, 1};

        new Solution();
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prodoct = new int[len];
        prodoct[0] = 1;
        for (int i = 1; i < len; i++) {
            prodoct[i] = prodoct[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            prodoct[i] = R * prodoct[i];
            R = R * nums[i];
        }
        return prodoct;
    }
}
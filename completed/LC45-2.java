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
    public int jump(int[] nums) {
        int len = nums.length;
        if (len==1){
            return 0;
        }
        int[] reach = new int[len];
        int maxReach = 0;
        int stpes = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                reach[0] = nums[0];
                maxReach = nums[0];
                stpes++;
            } else {
                reach[i] = Math.max(reach[i - 1], i + nums[i]);
                if (i<len-1 && i==maxReach){
                    stpes++;
                    maxReach = reach[i];
                }
            }
        }
        return stpes;
    }
}
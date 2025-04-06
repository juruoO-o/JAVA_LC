import java.lang.classfile.instruction.CharacterRange;
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
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        new Solution().lengthOfLIS(height);


    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(nums[i],Math.max(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1]));
            dpMin[i] = Math.min(nums[i],Math.min(nums[i]*dpMax[i-1],nums[i]*dpMin[i-1]));
        }
        int ans = (int) -(1e9);
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,dpMax[i]);
        }
        return ans;
    }
}
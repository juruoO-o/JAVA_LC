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
        int[] height = {1, 2, 2};
        new Solution().findDuplicate(height);


    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                //swap nums[i] and nums[nums[i]]
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
}
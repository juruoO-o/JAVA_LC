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
        int[] height = {2,3,1,1,4};
        new Solution().jump(height);


    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums.length==1)
            return 0;
        int[] reach = new int[nums.length];
        int cnt=1;
        int maxReach = nums[0];
        reach[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (reach[i-1]>=i){
                reach[i] = Math.max(reach[i - 1], nums[i] + i);
            }
            if (i>maxReach){
                cnt++;
                maxReach = reach[i-1];
            }
        }
        return cnt;
    }
}
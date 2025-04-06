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
        new Solution().solveNQueens(1);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left<=right){
            mid = (left+right)>>1;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                if (mid==0 || nums[mid-1]<target){
                    return mid;
                }
                right=mid-1;
            }else{
                if (mid == len-1 || nums[mid+1]>target){
                    return mid+1;
                }
                left=mid+1;
            }
        }
        return 0;
    }
}
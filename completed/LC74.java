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
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int[][] arr1 = {{1,3}};
        new Solution().searchMatrix(arr1,3);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m - 1;
        int mid;
        int i = 0;
        //find the row
        while (left <= right) {
            mid = (left + right) >> 1;
            if (matrix[mid][0] == target) {
                i = mid;
                break;
            } else if (matrix[mid][0] > target) {
                if (mid == 0)
                    return false;
                else if (matrix[mid - 1][0] < target) {
                    i = mid - 1;
                    break;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid == m - 1 || matrix[mid + 1][0] > target) {
                    i = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        //find the col
        left = 0;
        right = n - 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (matrix[i][mid]==target){
                return true;
            }else if (matrix[i][mid]<target){
                left = mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}
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
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {5, 2, 3, 1};

        new Solution().findDiagonalOrder(arr);
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int cnt = 0, len = m * n;
        int[] ans = new int[len];
        int i = 0, j = 0;
        boolean direction = true;
        while (cnt < len) {
            ans[cnt] = mat[i][j];
            if (direction) {
                if (i == 0 && j < n - 1) {
                    j++;
                } else if (j == n - 1) {
                    i++;
                } else {
                    i--;
                    j++;
                    direction = !direction;
                }
            } else {
                if (j == 0 && i < m - 1) {
                    i++;
                } else if (i == m - 1) {
                    j++;
                } else {
                    i++;
                    j--;
                    direction = !direction;
                }
            }
            direction = !direction;
            cnt++;
        }
        return ans;
    }
}
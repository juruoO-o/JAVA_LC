//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Solution().searchMatrix(nums, 5);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, 0, m - 1, n - 1);
    }

    public boolean search(int[][] matrix, int target, int start_i, int start_j, int end_i, int end_j) {
        if (start_i > end_i || start_j > end_j)
            return false;
        int mid_i = (start_i + end_i) >> 1, mid_j = (start_j + end_j) >> 1;
        if (matrix[mid_i][mid_j] == target) {
            return true;
        } else if (matrix[mid_i][mid_j] > target) {
            return search(matrix, target, start_i, start_j, mid_i - 1, mid_j - 1) ||
                    search(matrix, target, mid_i, start_j, end_i, mid_j - 1) ||
                    search(matrix, target, start_i, mid_j, mid_i - 1, end_j);
        } else {
            return search(matrix, target, mid_i + 1, mid_j + 1, end_i, end_j) ||
                    search(matrix, target, mid_i + 1, start_j, end_i, mid_j) ||
                    search(matrix, target, start_i, mid_j + 1, mid_i, end_j);
        }
    }
}
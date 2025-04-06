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
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {-2};
        List<String> strs = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        new Solution().maxSubarraySumCircular(height);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int minSum = 0;
        int tmpMinSum = 0;
        int maxSum = (int)-(1e9);
        int tmpMaxSum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            tmpMinSum += nums[i];
            tmpMaxSum += nums[i];
            if (tmpMinSum < minSum) {
                minSum = tmpMinSum;
            }
            if (tmpMinSum > 0) {
                tmpMinSum = 0;
            }
            if (tmpMaxSum>maxSum){
                maxSum = tmpMaxSum;
            }
            if (tmpMaxSum<0){
                tmpMaxSum =0;
            }
        }
        if (minSum == sum){
            minSum = maxSum;
        }
        return Math.max(sum-minSum,maxSum);
    }
}

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
        int[] height = {2, 3, 1, 1, 4};
        new Solution().partitionLabels("ababcbacadefegdehijhklij");


    }
}

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i * i);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int ele : squares) {
                if (i - ele < 0) {
                    break;
                } else {
                    dp[i] = dp[i] == 0 ?dp[i-ele]+1:Math.min(dp[i],dp[i-ele]+1);
                }
            }
        }
        return dp[n];
    }
}
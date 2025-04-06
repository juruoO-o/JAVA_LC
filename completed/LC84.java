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
        int[] height = {2,1,5,6,2,3};
        new Solution().largestRectangleArea(height);
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len], right = new int[len];
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                left[i] =  - 1;
            } else {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = len-1; i >=0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if (stk.isEmpty()){
                right[i]=len;
            }else{
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        for (int i = 0; i < len; i++) {
            int area = heights[i] * (right[i]-left[i]-1);
            ans = Math.max(area,ans);
        }
        return ans;
    }
}
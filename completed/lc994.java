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
        int i = new Solution().pathSum(root, 0);
        System.out.println(i);
    }
}

class Solution {
    class tool {
        int i;
        int j;
        int minute;

        tool(int a, int b, int c) {
            i = a;
            j = b;
            minute = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<tool> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new tool(i, j, 0));
                }
            }
        }
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            tool t = queue.poll();
            ans = t.minute;
            for (int i = 0; i < 4; i++) {
                int tx = t.i +x[i];
                int ty = t.j + y[i];
                if (tx>=0 && tx<m && ty>=0 && ty<n &&
                        grid[tx][ty]==1){
                    grid[tx][ty]=2;
                    queue.add(new tool(tx,ty,t.minute+1));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        new Solution().maxAreaOfIsland(nums);
    }
}


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] x_off = {-1, 0, 1, 0};
        int[] y_off = {0, 1, 0, -1};
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    int area = 0;
                    Queue<pair> q = new LinkedList<>();
                    q.add(new pair(i, j));
                    visit[i][j] = true;
                    while (!q.isEmpty()) {
                        pair tmp = q.poll();
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int nx = tmp.i + x_off[k];
                            int ny = tmp.j + y_off[k];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny] && grid[nx][ny] == 1) {
                                visit[nx][ny] = true;
                                q.add(new pair(nx, ny));
                            }
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }

    class pair {
        int i;
        int j;

        pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
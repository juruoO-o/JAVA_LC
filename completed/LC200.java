
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        char[][] grid={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        new Solution().numIslands(grid);

    }
}

class Solution {
    public boolean[][] visit;
    int m, n;
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false && grid[i][j] == '1'){
                    ans++;
                    bfs(grid,i,j);
                }
            }
        }
        return ans;
    }

    void bfs(char[][] grid, int i, int j) {
        Queue<Integer> qi, qj;
        qi = new LinkedList<>();
        qj = new LinkedList<>();
        qi.add(i);
        qj.add(j);
        visit[i][j] = true;
        int ti, tj, tx, ty;
        while (!qi.isEmpty()) {
            ti = qi.poll();
            tj = qj.poll();
            for (int k = 0; k < 4; ++k) {
                tx = ti + x[k];
                ty = tj + y[k];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n &&
                        visit[tx][ty] == false && grid[tx][ty] == '1') {
                    visit[tx][ty] = true;
                    qi.add(tx);
                    qj.add(ty);
                }
            }
        }
    }

}
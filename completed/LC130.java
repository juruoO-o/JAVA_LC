import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.management.ListenerNotFoundException;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        int[] height = {2, 5};
        List<String> strs = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        new Solution().ladderLength("hit", "cog", strs);

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
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!visit[0][i] && board[0][i] == 'O') {
                bfs(board, visit, m, n, 0, i);
            }
            if (!visit[m - 1][i] && board[m - 1][i] == 'O') {
                bfs(board, visit, m, n, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visit[i][0] && board[i][0]=='O'){
                bfs(board,visit,m,n,i,0);
            }
            if (!visit[i][n-1] && board[i][n-1]=='O'){
                bfs(board,visit,m,n,i,n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void bfs(char[][] board, boolean[][] visit, int m, int n, int i, int j) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(i, j));
        visit[i][j]=true;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> poll = q.poll();
            for (int k = 0; k < 4; k++) {
                int tx = poll.first + x[k];
                int ty = poll.second + y[k];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n
                        && !visit[tx][ty] && board[tx][ty]=='O') {
                    q.add(new Pair<>(tx,ty));
                    visit[tx][ty] = true;
                }
            }
        }
    }
}
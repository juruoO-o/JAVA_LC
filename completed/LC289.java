import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
import java.nio.charset.StandardCharsets;
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
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 87, 87, 87, 2, 1};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().findSubstring("wordgoodgoodgoodbestword", strs);
    }
}

class Solution {
    int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};

    public void gameOfLife(int[][] board) {
        List<pair> convert = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt=0;
                for (int k = 0; k < 8; k++) {
                    int px = x[k] + i;
                    int py = y[k] + j;
                    if (px>=0 && px<m && py>=0 && py <n){
                        if (board[px][py]==1){
                            cnt++;
                        }
                    }
                }
                if (board[i][j]==1 && (cnt<2 || cnt>3) ||
                board[i][j]==0 && cnt==3){
                    convert.add(make_pair(i, j));
                }
            }
        }
        for(pair p : convert){
            board[p.i][p.j] = 1-board[p.i][p.j];
        }
    }

    class pair {
        int i;
        int j;

        pair(int a, int b) {
            i = a;
            j = b;
        }
    }

    pair make_pair(int a, int b) {
        return new pair(a, b);
    }
}
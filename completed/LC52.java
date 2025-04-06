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
        new Solution().combine(4, 2);

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
    int[][] matrix;
    int n;
    int ans = 0;

    public int totalNQueens(int n) {
        matrix = new int[n][n];
        this.n = n;
        rec(0);
        return ans;
    }

    void rec(int line) {
        if (line==n){
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            matrix[line][i] = 1;
            if (check(matrix, line, i)) {
                rec(line + 1);
            }
            matrix[line][i] = 0;
        }
    }

    private boolean check(int[][] matrix, int i, int j) {
        int a = i, b = j - 1;
        while (b >= 0) {
            if (matrix[a][b] == 1)
                return false;
            --b;
        }
        b = j + 1;
        while (b < n) {
            if (matrix[a][b] == 1)
                return false;
            ++b;
        }
        a = i - 1;
        b = j;
        while (a >= 0) {
            if (matrix[a][b] == 1)
                return false;
            --a;
        }
        a = i + 1;
        while (a < n) {
            if (matrix[a][b] == 1)
                return false;
            ++a;
        }
        a = i - 1;
        b = j - 1;
        while (a >= 0 && b >= 0) {
            if (matrix[a][b] == 1)
                return false;
            a--;
            b--;
        }
        a = i + 1;
        b = j + 1;
        while (a < n && b < n) {
            if (matrix[a][b] == 1)
                return false;
            ++b;
            ++a;
        }
        a=i-1;
        b=j+1;
        while (a>=0 && b<n){
            if (matrix[a][b] == 1)
                return false;
            --a;
            ++b;
        }
        a=i+1;
        b=j-1;
        while (a<n && b>=0){
            if (matrix[a][b] == 1)
                return false;
            ++a;
            --b;
        }
        return true;
    }
}
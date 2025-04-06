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
    public boolean isValidSudoku(char[][] board) {
        int[][] cntRow = new int[9][9];
        int[][] cntCol = new int[9][9];
        int[][] cntBox = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c=='.'){
                    continue;
                }
                int box = (i / 3) * 3 + j / 3;
                int num = c-'1';
                //row
                if (cntRow[i][num]>0){
                    return false;
                }
                cntRow[i][num]++;
                //col
                if (cntCol[j][num]>0){
                    return false;
                }
                cntCol[j][num]++;
                //box
                if (cntBox[box][num]>0){
                    return false;
                }
                cntBox[box][num]++;
            }
        }
        return true;
    }
}
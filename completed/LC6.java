import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
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

        new Solution().reverseWords("the sky is blue");
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        boolean directionDown = true;
        for (int i = 0; i < len; i++) {
            sb[row].append(s.charAt(i));
            if (row==0){
                row++;
                directionDown = true;
            }else if (row==numRows-1){
                row--;
                directionDown = false;
            }else if (directionDown){
                row++;
            }else {
                row--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(sb[i].toString());
        }
        return ans.toString();
    }
}
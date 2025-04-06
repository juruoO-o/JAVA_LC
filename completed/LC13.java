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
        int[] height = {1,2,87,87,87,2,1};

        new Solution().candy(height);
    }
}

class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int res=0;
        for (int i = 0; i < len; i++) {
            if (i<len-1 && getPri(arr[i]) < getPri(arr[i+1])){
                res+=getVal(arr[i+1]) - getVal(arr[i]);
                ++i;
            }else{
                res+=getVal(arr[i]);
            }
        }
        return res;
    }
    int getPri(char c){
        return switch (c) {
            case 'I' -> 0;
            case 'V' -> 1;
            case 'X' -> 2;
            case 'L' -> 3;
            case 'C' -> 4;
            case 'D' -> 5;
            case 'M' -> 6;
            default -> 0;
        };
    }
    int getVal(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
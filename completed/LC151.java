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
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int pleft, pright = len - 1;
        char[] arr = s.toCharArray();
        //排除后空格
        while (pright >= 0 && arr[pright] == ' ') pright--;
        //提取单词
        while (pright >= 0) {
            //单词
            pleft = pright;
            while (pleft >= 0 && arr[pleft] != ' ') pleft--;
            sb.append(s.substring(pleft+1,pright+1)+' ');
            pright=pleft;
            //空格
            while (pright >= 0 && arr[pright] == ' ') pright--;
        }
        if (sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
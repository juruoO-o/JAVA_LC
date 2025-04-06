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

        new Solution().intToRoman(3749);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int start=0,end=0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans=0;
        //排除前导空格
        while (start<len&&arr[start]==' '){
            start++;
        }
        //处理
        while (end<len){
            //单词
            end=start;
            while (end<len &&arr[end]!=' ') end++;
            ans = end-start;
            start=end;
            //空格
            while (end<len && arr[end]==' ') end++;
            start=end;
        }
        return ans;
    }
}
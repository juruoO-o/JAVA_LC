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


/**
 * 模块化3ms，内联2ms
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        //K
        int numOfK = num / 1000;
        num %= 1000;
        build(sb,numOfK,'M',' ',' ');
        //H
        int numOfH = num / 100;
        num%=100;
        build(sb,numOfH,'C','D','M');
        //TEN
        int numOfT = num / 10;
        num%=10;
        build(sb,numOfT,'X','L','C');
        //N
        build(sb,num,'I','V','X');
        return sb.toString();
    }
    void build(StringBuilder sb,int num,char numOf1,char numOf5,char numOf10){
        if (num == 9){
            sb.append(numOf1);
            sb.append(numOf10)
        }else if (num == 4){
            sb.append(numOf1);
            sb.append(numOf5)
        }else{
            if (num>=5){
                sb.append(numOf5);
                num-=5;
            }
            while (num > 0) {
                num--;
                sb.append(numOf1);
            }
        }
    }
}
import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
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
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {2, 5};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().findMinArrowShots(arr1);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token:tokens){
            if (isOp(token)){
                stk.add(cal(stk.pop(),stk.pop(),token));
            }else{
                stk.add(Integer.valueOf(token));
            }
        }
        return stk.pop();
    }
    boolean isOp(String s){
        return "+".equals(s) ||
                "-".equals(s) ||
                "*".equals(s) ||
                "/".equals(s) ;
    }
    int cal(Integer i2,Integer i1,String op){
        switch (op){
            case "+": return i1+i2;
            case "-": return i1-i2;
            case "*": return i1*i2;
            case "/": return i1/i2;
        }
        return 0;
    }
}
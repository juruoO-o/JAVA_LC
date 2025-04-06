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
        new Solution().letterCombinations("23");

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
    List<String> ans = new ArrayList<>();
    char[][] arr = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)){
            return ans;
        }
        char[] dgt = digits.toCharArray();
        rec(dgt,0);
        return ans;
    }
    void rec(char[] dgt,int idx){
        if (idx == dgt.length){
            ans.add(sb.toString());
            return;
        }
        for(char c:arr[dgt[idx]-'2']){
            sb.append(c);
            rec(dgt,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
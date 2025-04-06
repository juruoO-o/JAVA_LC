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
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 87, 87, 87, 2, 1};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().findSubstring("wordgoodgoodgoodbestword", strs);
    }
}


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        String[] split = s.split(" ");
        Set<String> set = new HashSet<>();
        int len = pattern.length();
        if (len!=split.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            int idx = pattern.charAt(i) - 'a';
            if (map[idx]==null  ){
                if (!set.contains(split[i])){
                    map[idx] =split[i];
                    set.add(split[i]);
                }else {
                    return false;
                }
            }else if (!map[idx].equals(split[i])){
                return false;
            }
        }
        return true;
    }
}
import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.management.ListenerNotFoundException;
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
        List<String> strs = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        new Solution().ladderLength("hit", "cog", strs);
    }
}

class Solution {
    public int maxProductDifference(int[] nums) {
        int biggest = 0, secondBiggest = 0, smallest = (int) (1e9), secondSmallest = (int) (1e9);
        for(int num:nums){
            if (num>biggest){
                secondBiggest = biggest;
                biggest = num;
            }else if (num > secondBiggest){
                secondBiggest = num;
            }
            if (num<smallest){
                secondSmallest = smallest;
                smallest = num;
            }else if(num<secondSmallest){
                secondSmallest = num;
            }
        }
        return (biggest * secondBiggest) - (smallest * secondSmallest);
    }
}
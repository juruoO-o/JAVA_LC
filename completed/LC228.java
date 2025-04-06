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
        new Solution().isHappy(19);
    }
}


class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 0;
        int len = nums.length;
        List<String> ans = new ArrayList<>();
        while (right<len){
            while (right<len-1 && nums[right]+1 == nums[right+1]) right++;
            if (left<right){
                ans.add(nums[left]+"->"+nums[right]);
            }else{
                ans.add(nums[right]+"");
            }
            right++;
            left=right;
        }
        return ans;
    }
}
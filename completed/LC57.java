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
        int[][] arr1 = {{1, 3}, {6, 9}};
        int[] height = {2, 5};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().insert(arr1, height);
    }
}


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;
        if (newInterval[1] < intervals[0][0]) {
            ans.add(newInterval);
        }
        for (int i = 0; i < len;) {
            if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[0]||
                    intervals[i][1] >= newInterval[1] && intervals[i][0] <= newInterval[1]) {
                while (i < len &&
                        (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[0]||
                                intervals[i][1] >= newInterval[1] && intervals[i][0] <= newInterval[1])) {
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                    ++i;
                }
                ans.add(newInterval);
            } else {
                ans.add(intervals[i]);
            }
        }
        if (intervals[len - 1][1] < newInterval[0]) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
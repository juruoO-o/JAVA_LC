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
    public int findMinArrowShots(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b) -> {
            if (a[0] < b[0] || a[0] == b[0] && a[1] < b[1]) {
                return -1;
            } else if (a[0] > b[0] || a[0] == b[0] && a[1] > b[1])
                return 1;
            else return 0;
        });
        int len = points.length;
        for (int i = 0; i < len; i++) {
            int cur = i;
            while (i + 1 < len && points[i + 1][0] <= points[cur][1]) {
                ++i;
                if (points[i][1] < points[cur][1]) {
                    cur = i;
                }
            }
            ans++;
        }
        return ans;
    }

}
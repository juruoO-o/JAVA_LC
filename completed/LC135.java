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
        int[] height = {1,2,87,87,87,2,1};

        new Solution().candy(height);
    }
}

class Solution {
    public int candy(int[] ratings) {
        int start = 0, end = 0;
        int len = ratings.length;
        int ans = 0;
        int last = 0;
        if (len == 1) {
            return 1;
        }
        while (end < len - 1) {
            int cnt;
            end = start;
            if (ratings[end] < ratings[end + 1]) {
                while (end < len - 1 && ratings[end] < ratings[end + 1]) {
                    end++;
                }
                ans -= last;
                cnt = end - start + 1;
                ans += (1 + cnt) * cnt / 2;
                start = end;
                last = cnt;
            }
            //-----------------------------------
            else if (ratings[end] > ratings[end + 1]) {
                while (end < len - 1 && ratings[end] > ratings[end + 1]) {
                    end++;
                }
                cnt = end - start + 1;
                ans += (1 + cnt) * cnt / 2;
                ans-=Math.min(last,cnt);
                last=1;
                start = end;
            }
            //----------------------------------------
            else {
                while (end < len - 1 && ratings[end] == ratings[end + 1] ) {
                    end++;
                }
                ans+=(end-start+1);
                ans-=last;
                if (last>1){
                    ans+=(last-1);
                }
                last = 1;
                start = end;
            }
        }
        return ans;
    }
}

import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);

    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Solution::cmp);
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);
            } else {
                ans.add(intervals[i - 1]);
            }
        }

        ans.add(intervals[intervals.length - 1]);

        return ans.toArray(new int[ans.size()][2]);
    }

    static int cmp(int[] a, int[] b) {
        return a[0] < b[0] || a[0] == b[0] && a[1] < b[1] ? -1 :
                a[0] == b[0] && a[1] == b[1] ? 0 : 1;
    }
}
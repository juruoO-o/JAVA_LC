import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        int [][] interval = {
                {1,3},{8,10},{15,18},{2,6}
        };
        new Solution().merge(interval);
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,
                (a, b) -> ((a[0] - b[0]) << 15) + (a[1] - b[1]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1]= Math.max(interval[1],ans.getLast()[1]);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
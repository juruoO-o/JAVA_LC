import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int ans = 0;
        for (int ele : nums) {
            set.add(ele);
        }
        /**
         * 这个地方不能遍历nums，nums会有重复，set去重了
         */
        for (int ele : set) {
            if (!set.contains(ele - 1)) {
                int cnt = 1;
                int num = ele + 1;
                while (set.contains(num)) {
                    cnt += 1;
                    num += 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

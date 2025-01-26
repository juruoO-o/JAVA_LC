import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5, 25, 24, 5};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution();
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int ans = 0;
        char[] arr = s.toCharArray();
        int p1 = 0, p2 = 0;
        int len = arr.length;
        while (p2 < len) {
            while (p2 < len && cnt[(int) arr[p2]] == 0) {
                cnt[(int) arr[p2]]++;
                p2++;
            }
            ans = Math.max(ans, p2 - p1);
            if (p2 < len) {
                while (arr[p1] != arr[p2]) {
                    cnt[(int) arr[p1]]--;
                    ++p1;
                }
                ++p1;
                ++p2;
            }
        }
        return ans;
    }
}
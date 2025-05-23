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
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; --j) {
            right[j] = Math.max(right[j + 1], height[j]);
        }
        int ans = 0;
        for (int i = 1; i < len - 1; ++i) {
            ans +=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().maxSlidingWindow(nums1,3);
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k-1; i++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i+k-1]) {
                dq.pollLast();
            }
            dq.addLast(nums[i+k-1]);
            ans[i] = dq.peekFirst();
            if (dq.peekFirst() == nums[i]) {
                dq.pollFirst();
            }
        }
        return ans;
    }
}
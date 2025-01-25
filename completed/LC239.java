//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2}, nums2 = {2, 7};
        new Solution().compareVersion("1", "1.1");
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!dq.isEmpty() && nums[i] > dq.getLast())
                dq.removeLast();
            dq.addLast(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[i] > dq.getLast())
                dq.removeLast();
            dq.addLast(nums[i]);
            ans[i - k + 1] = dq.getFirst();
            if (nums[i - k + 1] == dq.getFirst())
                dq.removeFirst();
        }
        return ans;
    }
}
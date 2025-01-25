//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        new Solution().maxProduct(new int[]{-1,-2,-9,-6});
    }
}


class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpmax = new int[len];
        int[] dpmin = new int[len];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dpmax[i] = Math.max(nums[i], Math.max(nums[i] * dpmax[i - 1], nums[i] * dpmin[i - 1]));
            dpmin[i] = Math.min(nums[i], Math.min(nums[i] * dpmax[i - 1], nums[i] * dpmin[i - 1]));
        }
        int ans = -(1 << 30);
        for (int i = 0; i < len; i++) {
            ans = Math.max(dpmax[i], ans);
        }
        return ans;
    }
}
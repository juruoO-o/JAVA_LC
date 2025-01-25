
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
    public int trap(int[] height) {
        int len = height.length;
        int[] leftmax = new int[len], rightmax = new int[len];
        for (int i = 0; i < len; ++i) {
            leftmax[i] = Math.max(height[i], i > 0 ? leftmax[i - 1] : 0);
        }
        for (int i = len - 1; i >= 0; --i) {
            rightmax[i] = Math.max(height[i], i == len - 1 ? 0 : rightmax[i + 1]);
        }
        int ans=0;
        for (int i = 0; i < len; ++i) {
            ans+=Math.min(leftmax[i],rightmax[i]) - height[i];
        }
        return ans;
    }
}
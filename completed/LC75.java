
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
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int i = 0; i < nums.length; ++i) {
            cnt[nums[i]]++;
        }
        for (int i = 0, j = 0; i < nums.length; ++i) {
            while (cnt[j] == 0) {
                ++j;
            }
            nums[i] = j;
            cnt[j]--;
        }
    }
}
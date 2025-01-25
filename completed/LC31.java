//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,3,2}, nums2 = {2, 7};
        new Solution().nextPermutation(nums1);
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return;
        Stack<Integer> stk = new Stack<>();
        int idx1 = -1, idx2=len-1;
        for (int i = len - 1; i >= 0; --i) {
            if (stk.empty()||nums[i] >= nums[stk.peek()])
                stk.push(i);
            else {
                idx1 = i;
                break;
            }
        }
        ;
        if (stk.size() == len) {
            for (int i = 0; i < len / 2; ++i) {
                int tmp = nums[i];
                nums[i] = nums[len - i - 1];
                nums[len - i - 1] = tmp;
            }
        } else {
            idx2 = stk.peek();
            while (!stk.empty()&&nums[stk.peek()]>nums[idx1]){
                idx2 = stk.pop();
            }
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp ;
            Arrays.sort(nums,idx1+1,len);
        }
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().minWindow("aa", "aa");
    }
}

class Solution {
    List<Integer> v = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        rec(nums,0);
        return ans;
    }

    void rec(int[] nums, int height) {
        if(height == nums.length){
            ans.add(new ArrayList<>(v));
            return;
        }
        rec(nums,height+1);
        v.add(nums[height]);
        rec(nums,height+1);
        v.removeLast();
    }
}
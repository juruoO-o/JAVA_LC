//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2, 7};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rec(root,ans,0);
        return ans;
    }

    void rec(TreeNode root, List<Integer> ans,int height) {
        if(root==null)
            return;
        if(height==ans.size())
            ans.add(root.val);
        else
            ans.set(height,root.val);
        rec(root.left,ans,height+1);
        rec(root.right,ans,height+1);
    }
}
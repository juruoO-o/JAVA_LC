//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        rec(root,ans);
        return ans;
    }
    void rec(TreeNode root,List<Integer> ans){
        if (root.left!=null){
            rec(root.left,ans);
        }
        ans.add(root.val);
        if(root.right!=null){
            rec(root.right,ans);
        }
    }
}
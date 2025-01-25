//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Solution().searchMatrix(nums, 5);
    }
}


class Solution {
    int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        sum+= root.val;
        if(root.left==null && root.right == null && sum==targetSum)
            return true;
        boolean left=false,right=false;
        if(root.left!=null)
            left = hasPathSum(root.left,targetSum);
        if(root.right!=null)
            right = hasPathSum(root.right,targetSum);
        sum-= root.val;
        return left||right;
    }
}
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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null)
            rec(root, targetSum, 0);
        return ans;
    }

    void rec(TreeNode root, int target, int sum) {
        sum += root.val;
        tmp.add(root.val);
        if (sum == target && root.left==null && root.right==null) {
            ans.add(new ArrayList<>(tmp));
        }
        if (root.left != null) {
            rec(root.left, target, sum);
        }
        if (root.right != null) {
            rec(root.right, target, sum);
        }
        tmp.removeLast();
    }
}
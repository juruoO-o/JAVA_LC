//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        new Solution().diameterOfBinaryTree(new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(6)),new TreeNode(3)));
    }
}
class Solution {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root, 0);
        return ans;
    }

    public int traversal(TreeNode root, int height) {
        if (root == null)
            return height - 1;
        int left = traversal(root.left, height + 1);
        int right = traversal(root.right, height + 1);
        ans = Math.max(left + right - height * 2, ans);
        return Math.max(left, right);
    }
}
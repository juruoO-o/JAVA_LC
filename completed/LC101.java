//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        new Solution().isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3))));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return rec(root, root);
    }

    private boolean rec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if(root1!=null && root2==null || root1==null && root2!=null)
            return false;
        if (root1.val == root2.val)
            return rec(root1.left, root2.right) && rec(root1.right, root2.left);
        else
            return false;
    }
}
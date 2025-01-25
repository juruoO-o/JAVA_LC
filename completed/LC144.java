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
    List<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        traversal(root);
        return ans;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        ans.add(root.val);
        traversal(root.left);
        traversal(root.right);

    }

}
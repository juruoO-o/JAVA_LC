//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        new Solution().maxPathSum(root);
    }
}

class Solution {
    int global_max = -100000000;

    public int maxPathSum(TreeNode root) {
        rec(root);
        return global_max;
    }

    private int rec(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val;
        int left = rec(root.left);
        int right = rec(root.right);
        global_max = Math.max(global_max, sum + (left > 0 ? left : 0) + (right > 0 ? right : 0));
        return Math.max(sum + (left > 0 ? left : 0), sum + (right > 0 ? right : 0));
    }
}
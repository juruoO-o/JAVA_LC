//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
//        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6)));
        new Solution().flatten(root);
    }
}

class Solution {
    public void flatten(TreeNode root) {
        rec(root);
    }

    pair rec(TreeNode root) {
        if (null == root) {
            return new pair(null, null);
        }
        pair left = rec(root.left);
        pair right = rec(root.right);
        TreeNode tail=root;
        if (left.first!=null){
            root.left=null;
            root.right = left.first;
            tail = left.second;
        }
        if(right.first!=null){
            tail.right = right.first;
            tail = right.second;
        }
        return new pair(root,tail);
    }

    class pair {
        TreeNode first;
        TreeNode second;

        pair(TreeNode a, TreeNode b) {
            first = a;
            second = b;
        }
    }
}
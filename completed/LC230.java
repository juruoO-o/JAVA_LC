//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        new Solution();
    }
}

class Solution {
    int ans=-1;
    int cnt;

    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        rec(root);
        return ans;
    }

    void rec(TreeNode root) {
        if (null == root){
            return;
        }
        rec(root.left);
        if (--cnt==0)
            ans=root.val;
        rec(root.right);
    }
}
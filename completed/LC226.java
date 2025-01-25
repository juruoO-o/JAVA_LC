//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {0, 1, 1, 1, 1};
        int[] nums2 = {1,2};
        new Solution().rob(nums2);
        System.out.println();
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        rec(root);
        return root;
    }
    void rec(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right=tmp;
        rec(root.left);
        rec(root.right);
    }
}
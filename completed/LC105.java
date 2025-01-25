//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().minWindow("aa", "aa");
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode construct(int[] preorder, int[] inorder, int pres, int pree, int ins, int ine) {
        if (pres > pree)
            return null;
        int root = preorder[pres];
        int in_root_index = ins;
        while (in_root_index < ine) {
            if (inorder[in_root_index] == root)
                break;
            in_root_index++;
        }
        return new TreeNode(root, construct(preorder, inorder, pres + 1, pres + in_root_index - ins, ins, in_root_index - 1)
                , construct(preorder, inorder, pres + in_root_index - ins + 1, pree, in_root_index + 1, ine));
    }
}
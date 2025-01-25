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
        new Solution().diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3)));
    }
}

class Solution {
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        traversal(root);
        return flag;
    }

    pair traversal(TreeNode root) {
        pair left = null, right = null;
        pair res = new pair();
        if (root.left != null)
            left = traversal(root.left);
        if (root.right != null)
            right = traversal(root.right);
        if (left != null && root.val <= left.max)
            flag = false;
        if(right!=null && root.val >= right.min)
            flag=false;
        if(left==null)
            res.min =root.val;
        else
            res.min = left.min;
        if(right==null)
            res.max = root.val;
        else
            res.max = right.max;
        return res;
    }


    class pair {
        public int max;
        public int min;
    }
}
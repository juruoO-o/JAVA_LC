//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class Solution {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        rec(root,0);
        return ans;
    }

    private void rec(TreeNode root, int num) {
        num *= 10;
        num += root.val;
        if (root.left == null && root.left == root.right) {
            ans += num;
        }
        if (root.left != null) {
            rec(root.left, num);
        }
        if (root.right != null) {
            rec(root.right, num);
        }
    }
}
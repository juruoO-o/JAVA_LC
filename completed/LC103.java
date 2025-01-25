
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums, 3, nums2, 3);

    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> qt = new LinkedList<>();
        Queue<Integer> qh = new LinkedList<>();
        qt.add(root);
        qh.add(0);
        while (!qt.isEmpty()) {
            var tmp = qt.poll();
            var height = qh.poll();
            if (tmp.left != null) {
                qt.add(tmp.left);
                qh.add(height + 1);
            }
            if (tmp.right != null) {
                qt.add(tmp.right);
                qh.add(height + 1);
            }
            if (ans.size() == height)
                ans.add(new ArrayList<>());
            ans.get(height).add(tmp.val);
        }
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}
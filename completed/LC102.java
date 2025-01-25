
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(0);
        new Solution().mergeTwoLists(null, list3);

    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> qt = new LinkedList<>();
        Queue<Integer> qi = new LinkedList<>();
        qt.add(root);
        qi.add(0);
        while (!qt.isEmpty()) {
            TreeNode tmp = qt.poll();
            int level = qi.poll();
            if(tmp.left!=null){
                qt.add(tmp.left);
                qi.add(level+1);
            }
            if(tmp.right!=null){
                qt.add(tmp.right);
                qi.add(level+1);
            }
            if(ans.size()==level){
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(tmp.val);
        }
        return ans;
    }
}
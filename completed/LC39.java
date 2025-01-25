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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates,target,0,0);
        return ans;
    }
    public void rec(int[] candidates, int target,int sum,int idx){
        if(target == sum){
            ans.add(new ArrayList<>(tmp));
        }else if (sum>target)
            return;
        for (int i = idx; i < candidates.length; i++) {
            sum+=candidates[i];
            tmp.add(candidates[i]);
            rec(candidates,target,sum,i);
            sum-=candidates[i];
            tmp.removeLast();
        }
    }
}
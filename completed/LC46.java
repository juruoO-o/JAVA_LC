
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Solution().permute(nums);

    }
}

class Solution {
    boolean visit[];
    List<List<Integer>> ans;
    List<Integer> cur;
    int len;
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        visit = new boolean[len];
        ans = new ArrayList<>();
        cur = new ArrayList<>();
        recursion(nums);
        return ans;
    }
    private void recursion(int[] nums){
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if(!visit[i]){
                flag = false;
                visit[i]=true;
                cur.add(nums[i]);
                recursion(nums);
                cur.removeLast();
                visit[i] = false;
            }
        }
        if(flag){
            ans.add(new ArrayList<>(cur));
        }
    }
}
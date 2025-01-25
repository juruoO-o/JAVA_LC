
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        new Solution().maxProfit(nums);

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int[] q = new int[prices.length];
        int idx=-1;
        for (int i = 0; i < prices.length; i++) {
            while (idx>-1 && prices[i]<q[idx])
                idx--;
            ++idx;
            q[idx] = prices[i];
            if(idx>0){
                ans = Math.max(ans,q[idx]-q[0]);
            }
        }
        return ans;
    }
}
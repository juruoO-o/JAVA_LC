
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new Solution();

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int ans=-10000000;
        int sum=0;
        int i=0,len = nums.length;
        while (i<len){
            sum+=nums[i];
            ans = Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
            ++i;
        }
        return ans;
    }
}
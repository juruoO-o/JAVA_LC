
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums ={1,2,3,1};
        new Solution().rob(nums);

    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==1){
            return nums[0];
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = nums[0];
        dp2[1] = nums[1];
        dp1[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[len-2],dp2[len-1]);
    }
}
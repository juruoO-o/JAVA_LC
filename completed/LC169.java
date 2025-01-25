//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

        String s = new Solution().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.printf(s);
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ans = 1;
        for(int ele : nums){
            if(cnt == 0){
                cnt=1;
                ans=ele;
            }else if(ele==ans){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ans;
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2}, nums2 = {2, 7};
        new Solution().myAtoi("42");
    }
}


class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        double ans = 0;
        long intmax = (1<<31)-1;
        long intmin = -(1<<31);
        var str = s.toCharArray();
        int idx = 0;
        while (idx<len && str[idx] == ' ')
            idx++;
        int signal = 1;
        if (idx<len && (str[idx] =='+' || str[idx] == '-')){
            if(str[idx]=='-'){
                signal*=-1;
            }
            ++idx;
        }
        while (idx<len && str[idx] == '0')
            ++idx;
        while (idx<s.length() && str[idx]>='0' &&str[idx]<='9'){
            ans*=10;
            ans+=str[idx]-'0';
            idx++;
        }
        ans *=signal;
        if(ans>= intmax)
            return (int)intmax;
        else if (ans<=intmin)
            return (int)intmin;
        else{
            return (int)ans;
        }
    }
}
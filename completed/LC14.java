//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Solution().searchMatrix(nums, 5);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            String tmp = strs[i];
            int range = Math.min(ans.length(), tmp.length());
            int j=0;
            for (; j < range; j++) {
                if(ans.charAt(j)!=tmp.charAt(j))
                    break;
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }
}
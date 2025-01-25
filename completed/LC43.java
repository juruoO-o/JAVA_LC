//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().multiply("6", "501");
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) ||"0".equals(num2))
            return "0";
        int[] ans = new int[401];
        char[] str1 = num1.toCharArray(), str2 = num2.toCharArray();
        int len1 = str1.length, len2 = str2.length;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int mul = (str1[len1 - i - 1] - '0') * (str2[len2 - j - 1] - '0');
                ans[i + j] += mul;
            }
        }
        for (int i = 0; i < len1+len2; i++) {
            ans[i+1]+=ans[i]/10;
            ans[i]%=10;
        }
        int len = 400;
        while (ans[len] == 0)
            len--;
        StringBuilder sb = new StringBuilder(len + 1);
        for (; len >= 0; len--) {
            sb.append((char) ('0' + ans[len]));
        }
        return sb.toString();
    }
}
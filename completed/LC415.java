
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        String s1 = "99", s2 = "9";
        new Solution().addStrings(s1, s2);

    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; ++i) {
                num2 = '0' + num2;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                num1 = '0' + num1;
            }
        }
        char[] str1 = num1.toCharArray(), str2 = num2.toCharArray();
        int carry = 0;
        for (int i = str1.length - 1; i >= 0; --i) {
            int num = str1[i] + str2[i] - '0' - '0' + carry;
            carry = num/10;
            str1[i] = (char)(num%10 +'0');
        }
        String ans = new String(str1);
        if(carry == 1){
            ans = '1'+ans;
        }
        return ans;
    }
}
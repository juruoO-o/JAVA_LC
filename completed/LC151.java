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
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int fast = 0, slow = 0;
        int len = s.length();
        char[] str = s.toCharArray();
        while (str[fast] == ' ')
            fast++;
        slow = fast;
        while (fast < len) {
            while (fast<len && str[fast]!=' ')
                fast++;
            sb.append(new StringBuilder(s.substring(slow,fast)).reverse());

            while (fast < len && str[fast]==' ')
                fast++;
            slow=fast;
            if(fast < len)
                sb.append(' ');
        }

        return sb.reverse().toString();
    }
}
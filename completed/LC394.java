//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        new Solution().searchRange(nums, 8);
    }
}

class Solution {

    char[] str;
    int len;
    int idx=0;
    String st;
    public String decodeString(String s) {
        str = s.toCharArray();
        len = str.length;
        idx = 0;
        st = s;
        return rec();
    }

    String rec() {
        StringBuilder sb = new StringBuilder();
        for (; this.idx < len; ++idx) {
            if (str[idx] >= '0' && str[idx] <= '9') {
                int j=idx;
                while (str[idx] >= '0' && str[idx] <= '9') idx++;
                int times = Integer.parseInt(st.substring(j,idx));
                idx ++;
                String sub = rec();
                for (int i = 0; i < times; ++i) {
                    sb.append(sub);
                }
            } else if (str[idx] != ']') {
                sb.append(str[idx]);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
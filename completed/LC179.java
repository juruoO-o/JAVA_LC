//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        System.out.println("310".compareTo("3"));
//        new Solution().maxProduct(new int[]{-1, -2, -9, -6});
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int len1 = str1.length(), len2 = str2.length();
                int min = Math.min(len1, len2);
                if (len1 != len2 && str1.substring(0, min).equals(str2.substring(0, min))) {
                    if (len1 < len2) {
                        return compare(str1, str2.substring(min, len2));
                    } else {
                        return compare(str1.substring(min, len1), str2);
                    }
                }
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (!sb.isEmpty() && sb.charAt(0) == '0')
                sb.deleteCharAt(0);
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        new Solution().restoreIpAddresses("25525511135");
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            if (len - i > 9 || i>1 &&s.charAt(0)=='0')
                continue;
            String first = s.substring(0, i);
            if (Integer.parseInt(first) > 255)
                continue;
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                if (len - j > 6 || j-i>1 && s.charAt(i)=='0')
                    continue;
                String second = s.substring(i, j);
                if (Integer.parseInt(second) > 255)
                    continue;
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k > 3 || k-j>1 && s.charAt(j)=='0' || len-k>1 && s.charAt(k)=='0' )
                        continue;
                    String third = s.substring(j, k);
                    String fourth = s.substring(k, len);
                    if (Integer.parseInt(third) > 255 || Integer.parseInt(fourth) > 255)
                        continue;
                    ans.add(first + '.' + second + '.' + third + '.' + fourth);
                }
            }
        }
        return ans;
    }
}
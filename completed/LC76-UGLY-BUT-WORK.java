import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().minWindow("bbaac", "aba");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        //统计
        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, -1);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        String ans = "";
        int notCover = map.size();
        int start = 0, end = 0;
        //排除前缀无关字符
        while (start < s.length() && map.get(s.charAt(start)) == null) {
            start++;
        }
        if (start == s.length()) {
            return ans;
        }
        end = start;

        //开始找第一段符合要求的
        while (end < s.length() && notCover > 0) {
            Integer i = map.get(s.charAt(end));
            if (null != i) {
                if (i == -1) {
                    notCover--;
                }
                map.put(s.charAt(end), i + 1);
            }
            end++;
        }
        if (notCover == 0) {
            while (start < s.length() && (map.get(s.charAt(start)) == null || map.get(s.charAt(start)) > 0)) {
                if (map.get(s.charAt(start)) != null) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                start++;
            }

            String tmp = s.substring(start, end);
            if (tmp.length() < ans.length()) {
                ans = tmp;
            }

            ans = s.substring(start, end);
        }
        while (end < s.length()) {
            while (notCover == 0) {
                char c = s.charAt(start);
                Integer i = map.get(c);
                if (i != null && i == 0) {
                    notCover++;
                }
                if (null != i) {
                    map.put(c, i - 1);
                }
                ++start;
            }
            //去掉无关字符
            while (start < end && map.get(s.charAt(start)) == null) {
                ++start;
            }
            while (notCover > 0 && end < s.length()) {
                char c = s.charAt(end);
                Integer i = map.get(c);
                if (i != null && i == -1) {
                    notCover--;
                }
                if (i != null) {
                    map.put(c, i + 1);
                }
                end++;
            }
            while (start < s.length() && (map.get(s.charAt(start)) == null || map.get(s.charAt(start)) > 0)) {
                if (map.get(s.charAt(start)) != null) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                start++;
            }
            if (notCover == 0) {
                String tmp = s.substring(start, end);
                if (tmp.length() < ans.length()) {
                    ans = tmp;
                }
            }
        }
        while (start < s.length() && (map.get(s.charAt(start)) == null || map.get(s.charAt(start)) > 0)) {
            if (map.get(s.charAt(start)) != null) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            }
            start++;
        }
        if (notCover == 0) {
            String tmp = s.substring(start, end);
            if (tmp.length() < ans.length()) {
                ans = tmp;
            }
        }
        return ans;
    }
}
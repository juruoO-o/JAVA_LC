//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().minWindow("aa", "aa");
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        int diff = 0;
        int left = 0, right = 0;
        String ans = "";
        char[] str = s.toCharArray();
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0)
                diff++;
            cnt[c]++;
        }
        while (right < str.length) {
            char c = str[right];
            right++;
            cnt[c]--;
            if (cnt[c] == 0) {
                diff--;
            }
            while (diff == 0) {
                if (ans == "" || right - left < ans.length()) {
                    ans = s.substring(left, right);
                }
                char l = str[left];
                if (cnt[l] == 0) {
                    diff++;
                }
                cnt[l]++;
                left++;
            }
        }
        return ans;
    }
}
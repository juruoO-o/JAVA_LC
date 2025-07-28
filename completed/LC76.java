import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC {
    public static void main(String[] args) {
        new Solution().minWindow("a", "b");
    }
}


class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] cnt = new int[128];
        int distincet = 0;
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                distincet++;
            }
            cnt[c]++;
        }
        int left = 0, right = 0;
        String ans = "";
        while (right < s.length()) {
            while (right < s.length() && distincet > 0) {
                cnt[s.charAt(right)]--;
                if (cnt[s.charAt(right)] == 0) {
                    distincet--;
                }
                right++;
            }
            while (left <= right && distincet == 0) {
                if (cnt[s.charAt(left)] == 0) {
                    ans = (ans.isEmpty() || left < right && ans.length() > (right - left)) ? s.substring(left, right) : ans;
                    distincet++;
                }
                cnt[s.charAt(left)]++;
                left++;
            }

        }
        return ans;
    }
}
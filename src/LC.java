import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] cnt = new int[128];
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        while (right < len) {
            while (right < len && (cnt[arr[right]] ==0 || left==right)) {
                cnt[arr[right]]++;
                right++;
            }
            ans = Math.max(ans, right - left);
            if (right == len) {
                break;
            }
            cnt[arr[right]]++;
            while (cnt[arr[right]]==2){
                cnt[arr[left]]--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
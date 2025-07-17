import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().findAnagrams("cbaebabacd","abc");
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] cnt = new int[26];
        int noneZero = 0;
        for (char c : p.toCharArray()) {
            if (cnt[c - 'a'] == 0) {
                noneZero++;
            }
            cnt[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        for (; right < p.length(); right++) {
            cnt[arr[right] - 'a']--;
            if (cnt[arr[right] - 'a'] == 0) {
                noneZero--;
            }
        }
        if (noneZero == 0) {
            ans.add(0);
        }
        for (; right < arr.length;) {
            if (cnt[arr[left]-'a']==0){
                noneZero++;
            }
            cnt[arr[left]-'a']++;
            cnt[arr[right]-'a']--;
            if (cnt[arr[right]-'a']==0){
                noneZero--;
            }
            left++;
            right++;
            if (noneZero==0){
                ans.add(left);
            }
        }
        return ans;
    }
}
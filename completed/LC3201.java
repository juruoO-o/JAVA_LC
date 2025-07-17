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
    public int maximumLength(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnts = 0;
        int lasts = -1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= 2;
            if (nums[i] == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
            if (lasts == -1) {
                lasts = nums[i];
                cnts++;
            } else if (lasts != nums[i]) {
                lasts = 1 - lasts;
                cnts++;
            }
        }
        return Math.max(cnt0, Math.max(cnt1, cnts));
    }
}
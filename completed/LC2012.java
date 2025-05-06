import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution();
    }
}


class Solution {
    public int sumOfBeauties(int[] nums) {
        int ans = 0;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i], i == 0 ? 0 : prefix[i - 1]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = Math.min(nums[i],i==nums.length-1?nums[i]:suffix[i+1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (prefix[i - 1] < nums[i] && nums[i] < suffix[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}
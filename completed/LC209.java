import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2};
        List<String> str = new ArrayList<>();
        str.add("dog");
        str.add("s");
        str.add("gs");
        new Solution().minSubArrayLen(7, nums1);
        System.out.println("abc".compareTo("ab"));
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int rangeLeft = 0, rangeRight = 0, sum = 0;
        int ans = (int) 1e9;
        int len = nums.length;
        while (rangeRight < len && sum < target) {
            sum += nums[rangeRight++];
        }
        if (sum >= target) {
            ans = rangeRight - rangeLeft;
        }
        while (rangeRight < len) {
            if (sum >= target) {
                sum -= nums[rangeLeft];
                rangeLeft++;
            } else {
                sum += nums[rangeRight];
                rangeRight++;
            }
            if (sum >= target) {
                ans = Math.min(ans, rangeRight - rangeLeft);
            }
        }
        if (sum >= target) {
            while (sum >= target) {
                sum -= nums[rangeLeft];
                rangeLeft++;
            }
            rangeLeft--;
            ans = Math.min(ans, rangeRight - rangeLeft);
        }
        return ans == (int) 1e9 ? 0 : ans;
    }
}
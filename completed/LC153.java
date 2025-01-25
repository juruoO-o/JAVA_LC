import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        new Solution();
    }
}


class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0, mid, right = len - 1;
        int pre, post;
        while (left <= right) {
            mid = (left + right) >> 1;
            pre = (mid - 1 + len) % len;
            post = (mid + 1) % len;
            if (nums[mid] <= nums[pre] && nums[mid] <= nums[post]) {
                return nums[mid];
            } else if (nums[left] < nums[mid] && nums[mid] < nums[right] ||
                    nums[mid] < nums[right] && nums[right] < nums[left]
            ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
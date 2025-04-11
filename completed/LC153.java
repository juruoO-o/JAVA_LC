import javax.print.attribute.standard.PrinterURI;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        new Solution().searchRange(nums, 8);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}


class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            mid = (left + right) >> 1;
            if ((mid == nums.length - 1 || nums[mid] < nums[mid + 1]) &&
                    (mid == 0 || nums[mid] < nums[mid - 1])) {
                return nums[mid];
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
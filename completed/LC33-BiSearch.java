import javax.print.attribute.standard.PrinterURI;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        new Solution().search(nums, 0);

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
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid] && nums[left] <= target && nums[mid] > target ||
                    nums[left] > nums[mid] && (target >= nums[left] || target < nums[mid])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
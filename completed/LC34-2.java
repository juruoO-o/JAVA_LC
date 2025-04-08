import javax.print.attribute.standard.PrinterURI;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8,8};
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
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = -1;
        int[] ans = new int[2];
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > right) {
            ans[0] = ans[1] = -1;
        } else {
            int lleft = 0, lright = mid;
            int rleft = mid, rright = nums.length - 1;
            while (lleft <= lright) {
                mid = (lleft + lright) >> 1;
                if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                    ans[0] = mid;
                    break;
                } else if (nums[mid] < target) {
                    lleft = mid + 1;
                } else {
                    lright = mid-1;
                }
            }
            while (rleft <= rright) {
                mid = (rleft + rright) >> 1;
                if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                    ans[1] = mid;
                    break;
                } else if (nums[mid] > target) {
                    rright = mid - 1;
                } else {
                    rleft = mid+1;
                }
            }
        }
        return ans;
    }
}
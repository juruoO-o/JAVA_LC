import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {1, 2, 3, 1};
        new Solution().findPeakElement(nums);

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
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len==1){
            return 0;
        }
        int i = new Random().nextInt(0, len);
        if (i == 0 && nums[i] > nums[i + 1] ||
                i == len - 1 && nums[i] > nums[i - 1]) {
            return i;
        } else if (i != len - 1 && nums[i]<nums[i+1]){
            while (i<len-1 && nums[i]<nums[i+1]){
                ++i;
            }
            return i;
        }else{
            while (i>0 &&nums[i]<nums[i-1]){
                --i;
            }
            return i;
        }

    }
}
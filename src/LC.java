import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC {
    public static void main(String[] args) {
        new Solution().countMaxOrSubsets(new int[]{3, 1});
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin<end){
            nums[begin]+=nums[end];
            nums[end] = nums[begin]-nums[end];
            nums[begin]-=nums[end];
            begin++;
            end--;
        }
    }
}
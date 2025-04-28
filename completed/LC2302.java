import java.util.*;
import java.util.List;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().countSubarrays(new int[]{2,1,4,3,5}, 10);

    }
}

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long[] prefix = new long[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = search(prefix, i, nums.length, k);
            ans += idx - i;
        }
        return ans;
    }

    int search(long[] nums, int left, int right, long sup) {
        int mid;
        long cal;
        int ll=left;
        while (left < right) {
            mid = (left+right+1)>>1;
            cal = (nums[mid]-nums[ll])*(mid-ll);
            if (cal<sup){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
}
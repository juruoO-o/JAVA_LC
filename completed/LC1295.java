import java.util.*;
import java.util.List;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);

    }
}

class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            int r = 0;
            while (num>0){
                r++;
                num/=10;
            }
            if (r%2==0){
                cnt++;
            }
        }
        return cnt;
    }
}
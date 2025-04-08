import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {1,2,3,4,2,3,3,5,7};
        new Solution().minimumOperations(nums);

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
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        int rep = 0;
        for(int num:nums){
            if (cnt[num]==1){
                rep++;
            }
            cnt[num]++;
        }
        int ops = 0;
        int idx=0;
        int len = nums.length;
        while (rep>0){
            ops++;
            while (idx<len && idx<ops*3){
                cnt[nums[idx]]--;
                if (cnt[nums[idx]]==1){
                    rep--;
                }
                idx++;
            }
        }
        return ops;
    }
}
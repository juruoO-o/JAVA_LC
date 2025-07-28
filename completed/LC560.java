import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC {
    public static void main(String[] args) {
        new Solution().subarraySum(new int[]{1,1,1},2);
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans=0;
        for (int num : nums) {
            prefix+=num;
            ans+=map.getOrDefault(prefix-k,0);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return ans;
    }
}
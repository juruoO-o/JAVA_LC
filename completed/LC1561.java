import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

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
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int k = piles.length/3;
        for(int i=piles.length-2;k>0;--k){
            ans+=piles[i];
            i-=2;
        }
        return ans;
    }
}
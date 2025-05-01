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
    public double nthPersonGetsNthSeat(int n) {
        if (n==1){
            return 1.0;
        }else{
            return 0.5;
        }
    }
}
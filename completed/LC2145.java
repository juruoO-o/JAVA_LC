import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().rangeBitwiseAnd(5, 7);

    }
}


class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = 0,min=0;
        long num = 0;
        for (int i = 0; i < differences.length; i++) {
            num+=differences[i];
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        long ans = (upper-lower)-(max-min)+1;
        return ans<0?0:(int)ans;
    }
}
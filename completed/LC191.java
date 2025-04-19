import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution();

    }
}


class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        int mask =1;
        for (int i = 0; i < 32; i++) {
            if ((n&mask) !=0){
                ans++;
            }
            mask<<=1;
        }
        return ans;
    }
}
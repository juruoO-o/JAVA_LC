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
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            int x = i;
            while (x % 5 == 0) {
                x /= 5;
                ans++;
            }
        }
        return ans;
    }
}
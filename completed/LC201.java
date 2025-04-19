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
    public int rangeBitwiseAnd(int left, int right) {
        //按位与，其实就是求公共前缀
        int cnt = 0;
        while (left != right) {
            cnt++;
            left >>= 1;
            right >>= 1;
        }
        while (cnt-- > 0) {
            left <<= 1;
        }
        return left;
    }
}
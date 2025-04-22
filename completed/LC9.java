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
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int init = x;
        int reversed = 0;
        while (x>0){
            reversed*=10;
            reversed+=x%10;
            x/=10;
        }
        return init==reversed;
    }
}
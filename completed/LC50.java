import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        double res = new Solution().myPow(2,-2147483648);

    }
}


class Solution {
    public double myPow(double x, int n) {
        boolean sig = n<0;
        long p =n;
        p = sig?-p:p;
        double ans=1.0;
        double base = x;
        while (p>0){
            if ((p&1)==1){
                ans*=base;
            }
            base*=base;
            p>>=1;
        }
        return sig?1/ans:ans;
    }
}
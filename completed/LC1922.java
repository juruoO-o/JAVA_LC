import javax.management.relation.InvalidRelationTypeException;
import javax.print.attribute.standard.PrinterURI;
import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Parameter;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().myPow(2.0, -2147483648);

    }
}


class Solution {
    long mod = (long) (1e9) + 7;

    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n-odd;
        return (int)(quickMul(4,odd)*quickMul(5,even)%mod);
    }

    long quickMul(long base, long p) {
        long ans = 1;
        long contri = base;
        while (p > 0) {
            if (p % 2 == 1) {
                ans *= contri;
            }
            ans %= mod;
            contri *= contri;
            contri%=mod;
            p /= 2;
        }
        return ans;
    }
}
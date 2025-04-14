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
        new Solution().myPow(2.0,-2147483648);

    }
}

class Solution {
    public double myPow(double x, int n) {
        long N = N;
        boolean flag = N < 0;
        if (flag) {
            N = -N;
        }
        double ans = 1.0;
        double contri = x;
        while (N > 0) {
            if (N %2 == 1) {
                ans *= contri;
            }
            contri *= contri;
            N/=2;
        }
        if (flag) {
            return 1.0 / ans;
        } else {
            return ans;
        }
    }
}
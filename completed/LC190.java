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
        new Solution().reverseBits(964176192);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            ans=ans|((mask&n)==mask?1:0);
            mask=mask<<1;
            if (i<31)
                ans=ans<<1;
        }
        return ans;
    }
}
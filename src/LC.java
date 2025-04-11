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
        new Solution().robot("URR", obs, 3, 2);

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

class Tri<F, S, T> {
    F first;
    S second;
    T third;

    Tri(F f, S s, T t) {
        first = f;
        second = s;
        third = t;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 0; i <= amount ; i++) {
            for(int coin:coins){
                if (coin>i){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1 ? -1:dp[amount];
    }
}
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution();
    }
}


class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int less = dominoe[0];
            int more = dominoe[1];
            if (less > more) {
                int tmp = less;
                less = more;
                more = tmp;
            }
            map.put(less*10+more,map.getOrDefault(less*10+more,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            ans+= val*(val-1)/2;
        }
        return ans;
    }
}
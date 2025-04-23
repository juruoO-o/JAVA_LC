import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().mySqrt(8);

    }
}


class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] bits = new int[5];
        for (int i = 1; i <= n; i++) {
            int x = i;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum) + 1);
        }
        int ans=0;
        int max=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>max){
                max = entry.getValue();
                ans=1;
            }else if (entry.getValue()==max){
                ans++;
            }
        }
        return ans;
    }
}
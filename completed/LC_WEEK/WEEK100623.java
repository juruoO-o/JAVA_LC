import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().wordBreak("leetcode", List.of("leet", "code"));

    }
}


class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> xRec = new HashMap<>(), yRec = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            xRec.putIfAbsent(x, new TreeSet<>());
            yRec.putIfAbsent(y, new TreeSet<>());
            xRec.get(x).add(y);
            yRec.get(y).add(x);
        }
        int ans = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            TreeSet<Integer> yy = xRec.get(x);
            TreeSet<Integer> xx = yRec.get(y);
            if (yy.getFirst()!=y && yy.getLast()!=y&&
            xx.getFirst()!=x && xx.getLast()!=x){
                ans++;
            }
        }
        return ans;
    }
}
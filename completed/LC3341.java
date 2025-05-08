import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().minTimeToReach(new int[][]{
                {56, 93}, {3, 38}
        });
    }
}


class Solution {
    class point {
        public int val;
        public int x;
        public int y;

        public point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        PriorityQueue<point> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int m = moveTime.length;
        int n = moveTime[0].length;
        boolean[][] visit = new boolean[m][n];
        pq.add(new point(0, 0, 0));
        while (!pq.isEmpty()) {
            point poll = pq.poll();
            //不过滤会超时
            if(visit[poll.x][poll.y]){
                continue;
            }
            visit[poll.x][poll.y] = true;
            if (poll.x == m - 1 && poll.y == n - 1) {
                return poll.val;
            }
            for (int i = 0; i < 4; i++) {
                int tx = x[i] + poll.x;
                int ty = y[i] + poll.y;
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && !visit[tx][ty]) {
                    pq.add(new point(Math.max(moveTime[tx][ty], poll.val) + 1, tx, ty));
                }
            }
        }
        return -1;
    }
}
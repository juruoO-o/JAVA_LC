import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().numRabbits(new int[]{0,0,1,1,1});

    }
}


class Solution {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            cnt[answers[i]]++;
        }
        int ans = 0;
        ans += cnt[0];
        for (int i = 1; i < 1000; i++) {
            int k = i + 1;
            int v = cnt[i];
            ans+=( (v / k)*k + (v%k==0?0:k));
        }
        return ans;
    }
}
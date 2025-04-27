import java.util.*;
import java.util.List;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().pathExistenceQueries(4, new int[]{2, 5, 6, 8}, 2, new int[][]{
                {0, 1}, {0, 2}, {1, 3}, {2, 3}
        });

    }
}


class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] tree = new int[n];
        Arrays.fill(tree, 0, n, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ( Math.abs(nums[i] - nums[j]) <= maxDiff) {
                    int p1 = i, p2 = j;
                    while (tree[p1] != -1) p1 = tree[p1];
                    while (tree[p2] != -1) p2 = tree[p2];
                    tree[p2] = p1;
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int p1 = queries[i][0];
            int p2 = queries[i][1];
            if (p1 == p2) {
                ans[i] = true;
                continue;
            }
            while (tree[p1] != -1) p1 = tree[p1];
            while (tree[p2] != -1) p2 = tree[p2];
            ans[i] = (p1 == p2);
        }
        return ans;
    }
}
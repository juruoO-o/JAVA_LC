import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        new Solution().exist(board, "ABCB");
    }
}


class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s,0);
        return ans;
    }

    void dfs(String s, int idx) {
        if (idx == s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String substring = s.substring(idx, i);
            if (is(substring)){
                tmp.add(substring);
                dfs(s,i);
                tmp.removeLast();
            }
        }
    }

    boolean is(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i <= j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
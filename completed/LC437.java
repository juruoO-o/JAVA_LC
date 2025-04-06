import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                                                new TreeNode(1000000000),null),null),null),null),null);
        int i = new Solution().pathSum(root, 0);
        System.out.println(i);
    }
}
class Solution {
    List<Long> list = new ArrayList<>();
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        list.add(0L);
        rec(root, targetSum, 0L);
        // if(root.val == targetSum){
        //     ans++;
        // }
        return ans;
    }

    void rec(TreeNode root, int target, Long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        for (Long ele:list){
            if (sum-ele==target) {
                ans++;
            }
        }
        list.add((long) sum);
        rec(root.left, target, sum);
        rec(root.right, target, sum);
        list.removeLast();
    }
}
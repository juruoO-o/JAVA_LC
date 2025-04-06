import java.awt.image.AreaAveragingScaleFilter;
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
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {5, 2, 3, 1};

        new Solution().findDiagonalOrder(arr);
    }
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                System.out.println(tmp.val);
                q.add(tmp.left);
                q.add(tmp.right);
            }else{
                System.out.println("null");
                while (!q.isEmpty()){
                    if (q.poll() != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
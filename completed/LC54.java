
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 2, 3,4
                }, {
                5,6,7,8
        }, {
                9,10,11,12
        }
        };
        new Solution().spiralOrder(matrix);

    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, down = m - 1;
        int i = 0, j = 0;
        while (true) {
            while (j <= right) {
                ans.add(matrix[i][j]);
                ++j;
            }
            if(ans.size() == m*n)
                break;
            --j;
            ++i;
            ++top;
            while (i <= down) {
                ans.add(matrix[i][j]);
                ++i;
            }
            if(ans.size() == m*n)
                break;
            --i;
            --j;
            --right;
            while (j >= left) {
                ans.add(matrix[i][j]);
                --j;
            }
            if(ans.size() == m*n)
                break;
            --i;
            ++j;
            --down;
            while (i >= top) {
                ans.add(matrix[i][j]);
                --i;
            }
            ++j;
            ++i;
            ++left;
            if(ans.size() == m*n)
                break;
        }
        return ans;
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        new Solution().rotate(matrix);
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        double offset = (size - 1) / 2.0;
        for (int i = 0; i < (size >> 1) + (size % 2); i++) {
            for (int j = 0; j < (size >> 1) ; j++) {
                double X1 = i - offset, Y1 = j - offset;
                double X2 = Y1, Y2 = -X1;
                double X3 = -X1, Y3 = -Y1;
                double X4 = -X2, Y4 = -Y2;
                int tmp = matrix[i][j];
                matrix[(int) (X1 + offset)][(int) (Y1 + offset)] = matrix[(int) (X4 + offset)][(int) (Y4 + offset)];
                matrix[(int) (X4 + offset)][(int) (Y4 + offset)] = matrix[(int) (X3 + offset)][(int) (Y3 + offset)];
                matrix[(int) (X3 + offset)][(int) (Y3 + offset)] = matrix[(int) (X2 + offset)][(int) (Y2 + offset)];
                matrix[(int) (X2 + offset)][(int) (Y2 + offset)] = tmp;
            }
        }
    }
}
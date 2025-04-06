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
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {5,2,3,1};

        new Solution().sortArray(height);
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int mid = (beginIndex + endIndex) >> 1;
        mergeSort(nums, beginIndex, mid);
        mergeSort(nums, mid + 1, endIndex);
        int[] tmp = new int[endIndex - beginIndex + 1];
        int cnt=0;
        int i = beginIndex, j = mid + 1;
        while (i <= mid && j <= endIndex) {
            if(nums[i]<nums[j]){
                tmp[cnt] = nums[i];
                ++i;
            }else{
                tmp[cnt] = nums[j];
                ++j;
            }
            cnt++;

        }
        while (i<=mid){
            tmp[cnt] = nums[i];
            cnt++;
            i++;
        }
        while (j<=endIndex){
            tmp[cnt] = nums[j];
            cnt++;
            j++;
        }
        System.arraycopy(tmp,0,nums,beginIndex,tmp.length);
    }
}
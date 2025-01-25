//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2, 7};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
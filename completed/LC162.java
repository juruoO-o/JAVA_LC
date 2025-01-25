//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        new Solution().searchRange(nums, 8);
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0, right = len, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == len - 1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if((mid == 0 || nums[mid] > nums[mid - 1]) &&  (mid == len - 1 || nums[mid]<nums[mid+1])){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return 0;
    }
}
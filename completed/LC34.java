//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
        new Solution().searchRange(nums,8);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {-1, -1};
        int left = 0, right = nums.length-1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] == target) {
                int left1 = left, right1 = mid;
                int left2 = mid, right2 = right;
                while (left1 <= right1) {
                    mid = (left1 + right1) >> 1;
                    if(nums[mid]==target && (mid==0||nums[mid-1]!=target)){
                        ans[0]=mid;
                        break;
                    }
                    else if(nums[mid]<target)
                        left1=mid+1;
                    else
                        right1=mid-1;
                }
                while (left2 <= right2) {
                    mid = (left2 + right2) >> 1;
                    if(nums[mid]==target && (mid==len-1||nums[mid+1]!=target)){
                        ans[1]=mid;
                        break;
                    }
                    else if(nums[mid]>target)
                        right2=mid-1;
                    else
                        left2=mid+1;
                }
                break;
            }
        }
        return ans;
    }
}
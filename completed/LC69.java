//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2}, nums2 = {2, 7};
        new Solution().mySqrt(8);
    }
}


class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if(mid*mid<=x && (mid+1)*(mid+1)>x){
                return (int)mid;
            }else if(mid*mid > x){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return 0;
    }
}
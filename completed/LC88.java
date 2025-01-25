
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums, 3, nums2, 3);

    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, j = m - 1, k = n - 1;
        for (; i >= 0 &&j>=0 && k>=0; --i) {
            if( nums1[j]>nums2[k]){
                nums1[i]=nums1[j];
                --j;
            }else{
                nums1[i]=nums2[k];
                --k;
            }
        }
        if (k>=0){
            for (;k>=0;--k,--i){
                nums1[i]=nums2[k];
            }
        }
    }
}
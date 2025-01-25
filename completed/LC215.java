
import java.lang.classfile.components.ClassPrinter;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        int k=1;
        new Solution().findKthLargest(nums,k);

    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] cnt = new int[20001];
        int mx = -100000;
        for (int i = 0; i < nums.length; ++i) {
            cnt[nums[i]+10000]++;
            mx = Math.max(mx,nums[i]);
        }
        for(int i=mx+10000;i>=0;--i){
            k-=cnt[i];
            if(k<=0)
                return i-10000;
        }
        return -1;
    }
}
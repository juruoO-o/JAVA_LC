import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC {
    public static void main(String[] args) {
        new Solution().countMaxOrSubsets(new int[]{3, 1});
    }
}


class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int enums = 1 << nums.length;
        int ans=0;
        int max=-1;
        for (int i = 1; i < enums; i++) {
            int or = 0;
            int mask=1;
            for (int j = 0; j < nums.length; j++) {
                if ((i&mask)!=0){
                    or|=nums[j];
                }
                mask<<=1;
            }
            if (or>max){
                max=or;
                ans=1;
            }else if (or == max){
                ans++;
            }
        }
        return ans;
    }
}
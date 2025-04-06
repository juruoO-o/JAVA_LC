//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import javax.swing.*;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class LC {
    public static void main(String[] args) {
        int[] nums = {4,3,1,2,4};
        new Solution().beautifulSubarrays(nums);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}

class Solution {
    public long beautifulSubarrays(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                nums[i] = nums[i] ^ nums[i - 1];
            }
            Integer i1 = map.get(nums[i]);
            if (i1 == null) {
                map.put(nums[i], 1);
            }else{
                map.put(nums[i],i1+1);
            }
        }
        long ans = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            long cnt = entry.getValue();
            ans+= cnt*(cnt-1)/2;
        }
        return ans;
    }
}
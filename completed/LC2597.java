//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import javax.swing.*;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class LC {
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        new Solution().beautifulSubsets(nums,2);

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
    static Map<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        int len = nums.length;
        rec(nums,k,0,len);
        return ans;
    }
    void rec(int[] nums,int k,int idx,int len){
        if (idx==len){
            if(map.size()>0)
                ans++;
            return;
        }
        int num = nums[idx];
        if (map.get(num+k)==null && map.get(num-k)==null){
            map.merge(num, 1, Integer::sum);
            rec(nums,k,idx+1,len);
            if (map.get(num)==1){
                map.remove(num);
            }else{
                map.put(num,map.get(num)-1);
            }
        }
        rec(nums,k,idx+1,len);
    }
}
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {
                -1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {1, 2, 4, 8};
        new Solution().largestDivisibleSubset(nums);


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
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        ArrayList[] record = new ArrayList[len];
        int ansSize = -1;
        List<Integer> ans = null;
        for (int i = 0; i < len; i++) {
            int maxIndex = -1;
            dp[i]=1;
            for (int j = i - 1; j >= 0; --j){
                if (nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    maxIndex=j;
                }
            }
            ArrayList list ;
            if (maxIndex==-1){
                list = new ArrayList();
            }else{
                list=  new ArrayList(record[maxIndex]);
            }
            list.add(nums[i]);
            record[i] = list;
            if (record[i].size() > ansSize){
                ansSize=record[i].size();
                ans = record[i];
            }
        }
        return ans;
    }
}
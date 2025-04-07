import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {
                -1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {2, 2, 3, 5};
        new Solution().canPartition(nums);

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
    public int countWords(String[] words1, String[] words2) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str:words1) {
            Integer cnt = map.get(str);
            if (null == cnt) {
                map.put(str, 1);
            }else{
                map.put(str,cnt+1);
            }
        }
        for(String str:words2){
            Integer cnt = map.get(str);
            if(null==cnt){
                continue;
            }else{
                map.put(str,cnt+(1<<16));
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == (1<<16)+1){
                ans++;
            }
        }
        return ans;
    }
}
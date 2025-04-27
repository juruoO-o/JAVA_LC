import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        double res = new Solution().countInterestingSubarrays(List.of(3,1,9,6),3,0);

    }
}


class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map = new TreeMap<String,Integer>();
        for (List<String> respons : responses) {
            Set<String> set = new HashSet<>();
            for (String respon : respons) {
                set.add(respon);
            }
            for (String s : set) {
                Integer cnt = map.getOrDefault(s,0);
                map.put(s,cnt+1);
            }
        }
        String ans = "";
        int cnt = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue()>cnt){
                ans = entry.getKey();
                cnt = entry.getValue();
            }
        }
        return ans;
    }
}
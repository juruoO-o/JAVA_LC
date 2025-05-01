import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().wordBreak("leetcode",List.of("leet","code"));

    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        for (int i = 0; i <= len; i++) {
            for (String string : wordDict) {
                if (string.length()>i){
                    continue;
                }else {
                    dp[i] = dp[i-string.length()] && s.substring(i-string.length(),i).equals(string);
                    if (dp[i]){
                        break;
                    }
                }
            }
        }
        return dp[len];
    }
}
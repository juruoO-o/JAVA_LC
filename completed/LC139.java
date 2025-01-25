import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {0, 1, 1, 1, 1};
        int[] nums2 = {1, 2};
        List<String> str = new ArrayList<>();
        str.add("dog")
        str.add("s");
        str.add("gs");
        new Solution().wordBreak(new String("dogs"), str);
        System.out.println("abc".compareTo("ab"));
    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (String str : wordDict) {
                if (dp[i]){
                    break;
                }
                int strlen = str.length();
                if (strlen > i) {
                    continue;
                }else{
                    if (s.substring(i-strlen,i).equals(str)){
                        dp[i] = dp[i-strlen];
                    }
                }
            }
        }
        return dp[len];
    }
}
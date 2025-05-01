import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);

    }
}

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length()==1){
            return "";
        }
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!='a' && !((arr.length&1)==1 && i==arr.length/2)){
                arr[i]='a';
                return new String(arr);
            }
        }
        arr[arr.length-1]='b';
        return new String(arr);
    }
}
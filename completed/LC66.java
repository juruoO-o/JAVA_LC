import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution();

    }
}


class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for (int i = digits.length-1; i >=0; i--) {
            digits[i]+=carry;
            carry = digits[i]/10;
            digits[i]%=10;
        }
        if (carry==1){
            int[] ans = new int[digits.length + 1];
            ans[0]=1;
            return ans;
        }else{
            return digits;
        }
    }
}
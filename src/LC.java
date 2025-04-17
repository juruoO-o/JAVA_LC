import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().decodeString("3[a2[c]]");

    }
}


class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<String> stkStr = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
            } else if (c == '[') {
                stkNum.push(num);
                num = 0;
                stkStr.push(sb.toString());
                sb = new StringBuilder();
            }else if (c==']'){
                int times = stkNum.pop();
                String son = sb.toString();
                sb = new StringBuilder();
                sb.append(stkStr.pop());
                for (int i = 0; i < times; i++) {
                    sb.append(son);
                }
//                stkStr.push(sb.toString());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
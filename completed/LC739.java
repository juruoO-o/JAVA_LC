import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        new Solution();
    }
}


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<pair> stk = new Stack<>();
        stk.push(make_pair(temperatures[len - 1], len - 1));
        temperatures[len - 1] = 0;
        len -= 2;
        while (len >= 0) {
            while (!stk.isEmpty() && temperatures[len] >= stk.peek().first) {
                stk.pop();
            }
            int temp = temperatures[len];
            if (stk.isEmpty()) {
                temperatures[len] = 0;
            } else {
                temperatures[len] = stk.peek().second - len;
            }
            stk.push(make_pair(temp, len));
            --len;
        }
        return temperatures;
    }

    pair make_pair(int a, int b) {
        return new pair(a, b);
    }

    class pair {
        int first;
        int second;

        pair(int a, int b) {
            first = a;
            second = b;
        }
    }
}
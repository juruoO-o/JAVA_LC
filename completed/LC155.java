//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int fast = 0, slow = 0;
        int len = s.length();
        char[] str = s.toCharArray();
        while (str[fast] == ' ')
            fast++;
        slow = fast;
        while (fast < len) {
            while (fast < len && str[fast] != ' ')
                fast++;
            sb.append(new StringBuilder(s.substring(slow, fast)).reverse());

            while (fast < len && str[fast] == ' ')
                fast++;
            slow = fast;
            if (fast < len)
                sb.append(' ');
        }

        return sb.reverse().toString();
    }
}

class MinStack {

    private Stack<Integer> stk;
    private PriorityQueue<Integer> pq;

    public MinStack() {
        stk = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        stk.push(val);
        pq.add(val);
    }

    public void pop() {
        int val = stk.pop();
        pq.remove(val);
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return pq.peek();

    }
}

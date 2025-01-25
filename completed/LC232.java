//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2, 7};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}

class MyQueue {
    Stack<Integer> stk1,stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void push(int x) {
        stk1.add(x);
    }

    public int pop() {
        peek();
        return stk2.pop();
    }

    public int peek() {
        if(stk2.empty()){
            while (!stk1.empty()){
                stk2.add(stk1.pop());
            }
        }
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.empty()&&stk2.empty();
    }
}
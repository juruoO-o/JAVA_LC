
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(-4);
        p1.next=p2;
        p2.next=p3;
        p3.next=p1;
        new Solution().detectCycle(p1);

    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null ) {
            fast = fast.next;
            if (fast == null)
                return null;
            fast=fast.next;
            slow = slow.next;
            if(fast==slow){
                fast = head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
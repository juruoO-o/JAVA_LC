
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);

    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head,slowpre=null;
        while (fast != null) {
            slowpre = slow;
            fast = fast.next;
            slow = slow.next;
            if (fast != null)
                fast = fast.next;
        }
        slowpre.next=null;
        ListNode tmp = null;
        while (slow != null) {
            tmp = slow;
            slow = slow.next;
            tmp.next = fast;
            fast = tmp;
        }
        while (fast != null) {
            tmp = fast;
            fast = fast.next;
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }
    }
}
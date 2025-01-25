
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().reverseBetween(new ListNode(3,new ListNode(5)),1,2);

    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        ListNode l, r, op, tmp, tmph = null, cop;
        if (left == 1){
            l = null;
            op=head;
        }
        else {
            l = head;
            int cnt = 2;
            while (cnt < left) {
                cnt++;
                l = l.next;
            }
            op = l.next;
        }
        int cnt = 1;
        r = head;
        while (cnt < right) {
            cnt++;
            r = r.next;
        }
        if (r.next == null) {
            r = null;
        } else {
            r = r.next;
        }
        //start op
        cop = op;
        while (op != r) {
            tmp = op;
            op = op.next;
            tmp.next = tmph;
            tmph = tmp;
        }
        if (l != null)
            l.next = tmph;
        else
            head = tmph;
        cop.next = r;
        return head;
    }
}
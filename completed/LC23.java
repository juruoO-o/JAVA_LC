
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        ListNode[] lists = {
                new ListNode(1),
                new ListNode(0)
        };
        new Solution().mergeKLists(lists);

    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for (var list:lists){
            ans = merge(ans,list);
        }
        return ans;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode res, tail;
        res = tail = new ListNode();
        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next=l1;
                tail = l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                tail=l2;
                l2=l2.next;
            }
        }
        if(l1!=null)
            tail.next=l1;
        if(l2!=null)
            tail.next=l2;
        return res.next;
    }
}
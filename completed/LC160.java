
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);

    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans = null;
        int cnt1=0,cnt2=0;
        ListNode pa = headA,pb = headB;
        while (pa!=null){
            cnt1++;
            pa=pa.next;
        }
        while (pb!=null){
            cnt2++;
            pb=pb.next;
        }
        if(cnt1<cnt2){
            var tmpp = headA;
            headA = headB;
            headB = tmpp;
            var tmpn = cnt1;
            cnt1=cnt2;
            cnt2=tmpn;
        }
        while (cnt1>cnt2){
            headA=headA.next;
            cnt1--;
        }
        while (headA!=null){
            if(headA==headB)
                return headA;
            else{
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }
}
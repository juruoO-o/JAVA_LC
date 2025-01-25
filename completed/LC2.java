//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2}, nums2 = {2, 7};
        new Solution().mySqrt(8);
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2,prep1=null,prep2=null;
        int carry = 0;
        while (p1!=null && p2 !=null){
            int val = p1.val+p2.val+carry;
            carry = val/10;
            val%=10;
            l1.val = val;
            prep1 = p1;
            p1=p1.next;
            prep2=p2;
            p2=p2.next;
        }
        if(p1==null){
            prep1.next = p2;
        }
        p1=p2;
        if(carry==1){
            while (p1.val==9 && p1.next!=null){
                p1.val=0;
                p1=p1.next;
            }
            p1.val+=1;
            if(p1.val==10){
                p1.val=0;
                p1.next = new ListNode(1);
            }
        }
        return l1;
    }
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.ArrayList;
import java.util.List;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2, 7};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nh = new ListNode(0, head);
        ListNode p1 = nh, p2 = nh.next;
        while (p2 != null && p2.next != null) {
            if(p2.val==p2.next.val){
                int tmp = p2.val;
                while (p2!=null && p2.val==tmp){
                    p2=p2.next;
                }
                p1.next=p2;
            }else{
                p1=p1.next;
                p2=p2.next;
            }
        }
        return nh.next;
    }
}
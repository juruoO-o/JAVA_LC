//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {0, 1, 1, 1, 1};
        int[] nums2 = {1,2};
        new Solution().rob(nums2);
        System.out.println();
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p=head,q;
        while (p!=null){
            if(p.next!=null&&p.val==p.next.val){
                q=p;
                while (p!=null && p.val == q.val){
                    p=p.next;
                }
                q.next=p;
            }else{
                p=p.next;
            }
        }
        return head;
    }
}
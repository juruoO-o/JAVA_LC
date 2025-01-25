import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        List<String> str = new ArrayList<>();
        str.add("dog");
        str.add("s");
        str.add("gs");
        new Solution().subarraySum(nums2, );
        System.out.println("abc".compareTo("ab"));
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0, head);
        ListNode p1, p2, p3;
        p1 = sentinel;
        p2 = head;
        p3 = head.next;
        while (p1!=null){
            p2.next=p3.next;
            p1.next=p3;
            p3.next=p2;
            p1 = p2;
            p2=p1.next;
            if (p2!=null && p2.next!=null){
                p3=p2.next;
            }else{
                break;
            }
        }
        return sentinel.next;
    }
}
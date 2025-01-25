//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Solution().searchMatrix(nums, 5);
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null,tmp;
        ListNode fast = head, slow = head;
        boolean odd = false;
        while (fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }else{
                odd = true;
            }
            slow=slow.next;
        }
        while (head!=slow){
            tmp = head;
            head=head.next;
            tmp.next = reverse;
            reverse  = tmp;
        }
        if(odd)
            reverse=reverse.next;
        while (reverse!=null){
            if(reverse.val!=head.val)
                return false;
            reverse=reverse.next;
            head=head.next;
        }
        return true;
    }
}
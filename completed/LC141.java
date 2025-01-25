
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums, 3, nums2, 3);

    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null){
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            else
                return false;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
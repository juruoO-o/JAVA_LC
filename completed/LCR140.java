//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.constantpool.NameAndTypeEntry;
import java.lang.classfile.instruction.CharacterRange;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().longestValidParentheses("(()");
    }
}

class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head,slow=head;
        while (cnt-->0)
            fast=fast.next;
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(0);
        new Solution().mergeTwoLists(null, list3);

    }
}

class Solution {
    public int search(int[] nums, int target) {
        int idx = 0;
        if (nums[idx] > target) {
            idx = nums.length - 1;
            while (idx > 0 && nums[idx] > target) {
                --idx;
            }
            if (idx < nums.length && nums[idx] == target)
                return idx;
            else return -1;
        } else {
            while (idx < nums.length && nums[idx] < target)
                ++idx;
            if (idx < nums.length && nums[idx] == target)
                return idx;
            else return -1;
        }
    }
}
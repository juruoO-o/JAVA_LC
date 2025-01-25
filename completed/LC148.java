//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2, 7};

        new Solution().sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head, slowpre = null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slowpre = slow;
            slow = slow.next;
        }
        slowpre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        ListNode ret = null, tail = null;
        while (left != null && right != null) {
            ListNode tmp;
            if (left.val < right.val) {
                tmp = left;
                left = left.next;
            } else {
                tmp = right;
                right = right.next;
            }
            tmp.next = null;
            if (ret == null) {
                tail = tmp;
                ret = tail;
            } else {
                tail.next = tmp;
                tail = tmp;
            }
        }
        if (left != null) {
            if (ret == null) {
                return left;
            } else {
                tail.next = left;
            }
        }
        if (right != null) {
            if (ret == null) {
                return right;
            } else {
                tail.next = right;
            }
        }
        return ret;
    }
}
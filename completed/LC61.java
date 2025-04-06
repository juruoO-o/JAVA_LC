import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
import java.nio.charset.StandardCharsets;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {2, 5};
        String[] strs = {"word", "good", "best", "word"};
        new Solution().findMinArrowShots(arr1);
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tail = null, tmp;
        tmp = head;
        int len = 0;
        while (tmp != null) {
            if (tmp.next == null) {
                tail = tmp;
            }
            len++;
            tmp = tmp.next;
        }
        tail.next = head;
        ListNode fast = head, slow = head;
        k %= len;
        while (k-- > 0){
            fast=fast.next;
        }
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
        }
        head = slow.next;
        slow.next=null;
        return head;
    }
}
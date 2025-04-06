import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        new Solution().productExceptSelf(nums2);
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        List<Node> old = new ArrayList<>();
        Node tmp = head;
        while (tmp != null) {
            old.add(tmp);
            tmp = tmp.next;
        }
        Node newHead = null, newTail = null;
        List<Node> newRecord = new ArrayList<>();
        for (int i = 0; i < old.size(); i++) {
            Node node = new Node(old.get(i).val);
            newRecord.add(node);
            if (newHead == null) {
                newHead = newTail = node;
            } else {
                newTail.next = node;
                newTail = node;
            }
        }
        for (int i = 0; i < old.size(); i++) {
            int idx = old.indexOf(old.get(i).random);
            newRecord.get(i).random = idx==-1?null:newRecord.get(idx);
        }
        return newHead;
    }
}
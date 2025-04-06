import java.awt.image.AreaAveragingScaleFilter;
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
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 2};

        new Solution().removeKdigits("1234567890", 9);
    }
}

class Solution {
    public Node treeToDoublyList(Node root) {
        pair rec = rec(root);
        return rec.head;
    }

    pair rec(Node root) {
        if (null == root) {
            return new pair();
        }
        pair left = rec(root.left);
        pair right = rec(root.right);
        pair res = new pair();
        if (left.head == null) {
            res.head = res.tail = root;
        } else {
            res.head = left.head;
            left.tail.right = root;
            root.left = left.tail;
            res.tail = root;
        }
        if (null != right.head) {
            root.right = right.head;
            right.head.left = root;
            res.tail = right.tail;
        }
        res.tail.right = res.head;
        res.head.left = res.tail;
        return res;
    }

    class pair {
        Node head;
        Node tail;

        pair() {
            head = null;
            tail = null;
        }
    }
}
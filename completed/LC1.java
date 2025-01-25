
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
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (mp.get(target - nums[i]) != null) {
                ans[0] = i;
                ans[1] = mp.get(target - nums[i]);
                return ans;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}
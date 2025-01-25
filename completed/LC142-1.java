
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);

    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p!=null){
            if(set.contains(p))
                return p;
            set.add(p);
            p=p.next;
        }
        return null;
    }
}
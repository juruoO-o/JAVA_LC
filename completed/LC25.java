
import java.lang.classfile.components.ClassPrinter;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        new Solution().reverseKGroup(n1,2);

    }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resh = null, rest = null, tmp = null, tmph = null, p = null,tmpt=null;
        int cnt;
        while (head != null) {
            cnt = k;
            tmp = head;
            while (cnt > 0 && head != null) {
                cnt--;
                head = head.next;
            }
            if (cnt > 0) {
                if (resh == null)
                    return tmp;
                else
                    rest.next = tmp;
            } else {
                tmph=null;
                tmpt=tmp;
                while (head != tmp) {
                    p = tmp;
                    tmp = tmp.next;
                    p.next = tmph;
                    tmph = p;
                }
                if(resh == null){
                    resh = tmph;
                    rest = tmpt;
                }else{
                    rest.next=tmph;
                    rest=tmpt;
                    rest.next=null;
                }
            }
        }
        return resh;
    }
}
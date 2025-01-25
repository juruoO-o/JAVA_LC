
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode list3 = new ListNode(0);
        new Solution().mergeTwoLists(null,list3);

    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode ans = null, tail = null;
        ListNode tmp;
        while (list1!=null && list2!=null){
            if(list1.val < list2.val){
                tmp = list1;
                list1 = list1.next;

            }else{
                tmp = list2;
                list2=list2.next;
            }
            tmp.next=null;
            if(ans==null){
                ans = tail = tmp;
            }else{
                tail.next=tmp;
                tail = tmp;
            }
        }
        if(list1!=null){
            tail.next=list1;
        }
        if(list2!=null){
            tail.next=list2;
        }
        return ans;
    }
}
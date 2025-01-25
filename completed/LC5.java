
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
    public String longestPalindrome(String s) {
        int maxlen=-1;
        String ans="";
        char[] chararr = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            //state1 odd
            int left = i,right=i;
            while (left>=0 && right<len && chararr[left]==chararr[right]){
                --left;
                ++right;
            }
            if(right-left+1 > maxlen){
                maxlen = right-left+1;
                ans = s.substring(left+1,right);
            }
            //state2 even
            left = i;
            right=i+1;
            while (left>=0 && right<len && chararr[left]==chararr[right]){
                --left;
                ++right;
            }
            if(right-left+1 > maxlen){
                maxlen = right-left+1;
                ans = s.substring(left+1,right);
            }
        }
        return ans;
    }
}
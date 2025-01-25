//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.constantpool.NameAndTypeEntry;
import java.lang.classfile.instruction.CharacterRange;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {2, 7};
        new Solution().longestValidParentheses("(()");
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxcnt = -1;
        stk.push(-1);
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                stk.push(i);
            }else{
                stk.pop();
                if(stk.empty()){
                    stk.push(i);
                }else{
                    maxcnt = Math.max(maxcnt,i-stk.peek());
                }
            }
        }
        return maxcnt ;
    }
}
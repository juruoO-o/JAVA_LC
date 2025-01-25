
import java.lang.classfile.Interfaces;
import java.lang.classfile.components.ClassPrinter;
import java.security.KeyPair;
import java.util.*;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        String s = "(]";
        new Solution().isValid(s);

    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == '(' || c == '[' || c == '{') {
                stk.add(c);
            } else {
                if(stk.isEmpty())
                    return false;
                char t = stk.pop();
                if (c == ')' && t != '(') {
                    return false;
                } else if (c == ']' && t!='[') {
                    return false;
                }else if(c=='}' && t!='{'){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
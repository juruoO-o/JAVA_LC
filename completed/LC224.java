import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s ="-2+ 1";
        new Solution().calculate(s);
    }
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk_num = new Stack<>();
        Stack<Character> stk_op = new Stack<>();
        int idx = 0;
        int mark=-1;
        while(idx<s.length()){
            char c = s.charAt(idx);
            if(c == ' '){
                ++idx;
            }else if(c>='0' && c<='9'){
                int begin = idx;
                while(idx<s.length()&&s.charAt(idx)<='9' && s.charAt(idx)>='0'){
                    ++idx;
                }
                int num = Integer.parseInt(s.substring(begin, idx));
                stk_num.push(num);
                mark = 0;
            }else{
                switch (c) {
                    case '(':
                        stk_op.push(c);
                        mark=1;
                        break;
                    case ')':
                        while(stk_op.peek()!='('){
                            int opnum2 = stk_num.pop();
                            int opnum1 = stk_num.isEmpty()?0:stk_num.pop();
                            char op = stk_op.pop();
                            stk_num.push(cal(opnum1, opnum2, op));
                        }
                        stk_op.pop();
                        break;
                    case '+':
                    case '-':
                        if(stk_op.isEmpty() || stk_op.peek()=='('){
                            if(mark==1){
                                stk_num.push(0);
                            }
                            stk_op.push(c);
                        }else{
                            int opnum2 = stk_num.pop();
                            int opnum1 = stk_num.pop();
                            char op = stk_op.pop();
                            stk_num.push(cal(opnum1, opnum2, op));
                            stk_op.push(c);
                        }
                        break;
                    case '*':
                    case '/':
                        if(stk_op.isEmpty() || stk_op.peek()=='(' || get_pri(stk_op.peek())==0){
                            stk_op.push(c);
                        }else{
                            int opnum2 = stk_num.pop();
                            int opnum1 = stk_num.pop();
                            char op = stk_op.pop();
                            stk_num.push(cal(opnum1, opnum2, op));
                            stk_op.push(c);
                        }
                        break;
                }
                ++idx;
            }
        }
        while(!stk_op.isEmpty()){
            int opnum2 = stk_num.pop();
            int opnum1 = stk_num.pop();
            char op = stk_op.pop();
            stk_num.push(cal(opnum1, opnum2, op));
        }
        return stk_num.pop();
    }
    int get_pri(char c){
        if(c=='+' || c=='-'){
            return 0;
        }else{
            return 1;
        }
    }
    int cal(int num1,int num2,char op){
        return switch (op) {
            case '+' -> num1+num2;
            case '-' -> num1-num2;
            case '*' -> num1*num2;
            default -> num1/num2;
        };
    }
}
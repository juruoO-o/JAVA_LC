//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        new Solution().calculate(s);
        System.out.println();
    }
}



class Solution {
    public int calculate(String s) {
        int len = s.length();
        int[] arr = new int[len];
        int index = 0;
        char op = '+';
        int i = 0;
        while(i < len){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
            }else if(ch >= '0' && ch <= '9'){
                int tmp = 0;
                while(ch >= '0' && ch <= '9'){
                    tmp *= 10;
                    tmp += (ch - '0');
                    i++;
                    if(i < len){
                        ch = s.charAt(i);
                    }else{
                        break;
                    }
                }
                if(op == '+'){
                    arr[index++] = tmp;
                }else if(op == '-'){
                    arr[index++] = -tmp;
                }else if(op == '*'){
                    arr[index - 1] *= tmp;
                }else{
                    arr[index - 1] /= tmp;
                }
            }else{
                op = ch;
                i++;
            }
        }
        int sum = 0;
        for(i = 0; i < index; i++){
            sum += arr[i];
        }
        return sum;
    }
}
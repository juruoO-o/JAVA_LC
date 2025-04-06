package PDD3_23;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class PDD3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] stkHeight = new int[len];
        int[] stkIndex = new int[len];
        int top = -1;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int height = Integer.valueOf(split[i]);
            while (top>=0 && height>=stkHeight[top]){
                ans+=(i-stkIndex[top]);
                top--;
            }
            top++;
            stkHeight[top]=height;
            stkIndex[top]=i;
        }
        while (top>=0){
            ans+=(len-1-stkIndex[top]);
            top--;
        }
        System.out.println(ans);
    }
}
package PDD3_23;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class PDD2 {
    public static void main(String[] args) {
        int[] exclude = {1,2,4,5,7,8,11,14,17,22,25,28,41,44,47,52,55,58,71,74,77,82,85,88};
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        while (round-- >0){
            long left = in.nextLong();
            long right = in.nextLong();
            long ans = right-left+1;
            for(int ele:exclude){
                if (ele>=left && ele<=right){
                    ans--;
                }else if (ele>right){
                    break;
                }
            }
            System.out.println(ans);
        }
//        for(int i=1;i<100;++i){
//            if (i%3!=0 && i%10%3!=0 && i/10%3!=0){
//                System.out.print(i+",");
//            }
//        }
    }
}
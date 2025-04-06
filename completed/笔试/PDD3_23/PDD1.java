package PDD3_23;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class PDD1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        while (round-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            for (char c : s.toCharArray()) {
                if (c == 'W') {
                    y++;
                } else if (c == 'S') {
                    y--;
                } else if (c == 'A') {
                    x--;
                } else {
                    x++;
                }
            }
            if (x == 0 && y == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
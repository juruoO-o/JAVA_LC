package PDD3_23;

import java.util.Scanner;
import java.util.TreeSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class PDD4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        while (round-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            String strA = in.nextLine();
            char[] arrA = strA.toCharArray();
            String strB = in.nextLine();
            String arrX = in.nextLine();
            String[] split = arrX.split(" ");
            int[] cnt = new int[26];
            for (char c : strB.toCharArray()) {
                cnt[c - 'a']++;
            }
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (String str : split) {
                treeSet.add(Integer.valueOf(str));
            }
            int minChar = 0;
            while (cnt[minChar] == 0) {
                minChar++;
            }
            for (Integer index : treeSet) {
                arrA[index-1] = (char) (minChar + 'a');
                cnt[minChar]--;
                while (minChar<26 &&cnt[minChar] == 0) {
                    minChar++;
                }
            }
            System.out.println(new String(arrA));
        }
    }
}
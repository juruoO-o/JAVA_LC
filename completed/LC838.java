import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().pushDominoes("RR.L");

    }
}


class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int left = 0, right = 0;
        int len = dominoes.length();
        while (right < len) {
            while (left < len && arr[left] != '.') left++;
            right = left;
            while (right < len && arr[right] == '.') right++;
            int rl = left, rr = right - 1;
            left--;
            if ((left == -1 || arr[left] == 'L') && right < len && arr[right] == 'L') {
                for (int i = rl; i < right; i++) {
                    arr[i] = 'L';
                }
            } else if ((right == len || arr[right] == 'R') && left >= 0 && arr[left] == 'R') {
                for (int i = rl; i < right; ++i) {
                    arr[i] = 'R';
                }
            } else if (left >= 0 && arr[left] == 'R' && right < len && arr[right] == 'L') {
                while (rl < rr) {
                    arr[rl] = 'R';
                    arr[rr] = 'L';
                    rl++;
                    rr--;
                }
            }
            left = right;
        }
        return new String(arr);
    }
}
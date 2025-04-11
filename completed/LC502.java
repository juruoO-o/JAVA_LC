import javax.management.relation.InvalidRelationTypeException;
import javax.print.attribute.standard.PrinterURI;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        new Solution().searchRange(nums, 8);

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (k>0){
            while (idx < len && w >= arr[idx][1]) {
                pq.add(arr[idx][0]);
                idx++;
            }
            Integer poll = pq.poll();
            if (poll!=null){
                w+=poll;
            }
            k--;
        }
        return w;
    }
}
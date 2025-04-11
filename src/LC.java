import javax.management.relation.InvalidRelationTypeException;
import javax.print.attribute.standard.PrinterURI;
import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Parameter;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        new Solution().numberOfPowerfulInt(141, 148, 9, "9");

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

class Tri<F, S, T> {
    F first;
    S second;
    T third;

    Tri(F f, S s, T t) {
        first = f;
        second = s;
        third = t;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] first = new int[3];
        first[0] = nums1[0] + nums2[0];
        pq.offer(first);
        while (k-- > 0) {
            int[] poll = pq.poll();
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(poll[1]);
            tmp.add(poll[2]);
            ans.add(tmp);
            int[] ints = new int[3];
            if (poll[1] + 1 < nums1.length && poll[2] + 1 < nums2.length && nums1[poll[1] + 1] + nums2[poll[2]] < nums1[poll[1]] + nums2[poll[2] + 1]) {
                ints[0] = nums1[poll[1] + 1] + nums2[poll[2]];
                ints[1] = poll[1] + 1;
                ints[2] = poll[2];
            } else {
                ints[0] = nums1[poll[1]] + nums2[poll[2] + 1];
                ints[1] = poll[1];
                ints[2] = poll[2] + 1;
            }
            pq.offer(ints);
        }
        return ans;
    }

}
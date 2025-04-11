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
        PriorityQueue<Tri<Integer, Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        for (int i = 0; i < nums1.length; i++) {
            pq.add(new Tri<>(nums1[i] + nums2[0], i, 0));
        }
        while (k > 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            Tri<Integer, Integer, Integer> poll = pq.poll();
            tmp.add(nums1[poll.second]);
            tmp.add(nums2[poll.third]);
            ans.add(tmp);
            if (poll.third+1 < nums2.length){
                pq.add(new Tri<>(nums1[poll.second]+nums2[poll.third+1], poll.second, poll.third+1));
            }
            k--;
        }
        return ans;
    }

}
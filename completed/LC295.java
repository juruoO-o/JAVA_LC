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
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().robot("URR", obs, 3, 2);

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

class MedianFinder {
    int cnt=0;
    PriorityQueue<Integer> less,more;

    public MedianFinder() {
        less = new PriorityQueue<>((a,b)->b-a);
        more = new PriorityQueue<>();
    }

    public void addNum(int num) {
        cnt++;
        if ((cnt&1)==1){
            if (more.isEmpty() ||num<more.peek()){
                less.add(num);
            }else{
                less.add(more.poll());
                more.add(num);
            }
        }else{
            if (less.peek()>num){
                more.add(less.poll());
                less.add(num);
            }else{
                more.add(num);
            }
        }
    }

    public double findMedian() {
        if ((cnt&1)==1){
            return (double) less.peek();
        }else{
            return (less.peek()+ more.peek())/2.0;
        }
    }
}

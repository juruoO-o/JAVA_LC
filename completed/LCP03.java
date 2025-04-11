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
                {2,2}
        };
        new Solution().robot("URR",obs,3,2);

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
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<Long> set = new HashSet<>();
        int moveX = 0, moveY = 0;
        for (char c : command.toCharArray()) {
            set.add((((long) moveX << 31) + moveY));
            if (c == 'U') {
                moveY++;
            } else {
                moveX++;
            }
        }
        for (int[] loc : obstacles) {
            int locx = loc[0];
            int locy = loc[1];
            if (locx>x || locy>y){
                continue;
            }
            while (locx >= moveX && locy >= moveY) {
                locx -= moveX;
                locy -= moveY;
            }
            if (set.contains(((long)locx<<31)+locy)){
                return false;
            }
        }
        while (x>=moveX && y>=moveY){
            x-=moveX;
            y-=moveY;
        }
        if (set.contains((((long)x)<<31)+y)){
            return true;
        }
        return false;
    }
}
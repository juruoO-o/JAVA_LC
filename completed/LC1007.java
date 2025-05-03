import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution();
    }
}

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top = tops[0];
        int bot = bottoms[0];
        int topTop = 1;
        int topBot = 0;
        int botTop = 0;
        int botBot = 1;
        int len = tops.length;
        for (int i = 1; i < len; i++) {
            if (tops[i] == top) {
                topTop++;
            }
            if (tops[i] == bot) {
                botTop++;
            }
            if (bottoms[i] == top) {
                topBot++;
            }
            if (bottoms[i] == bot) {
                botBot++;
            }
            if (top != tops[i] && top != bottoms[i]) {
                top = -1;
            }
            if (bot != tops[i] && bot != bottoms[i]) {
                bot = -1;
            }
        }
        if (top == -1 && bot == -1) {
            return -1;
        } else if (top == -1) {
            return Math.min(len - botTop, len - botBot);
        } else if (bot == -1) {
            return Math.min(len - topTop, len - topBot);
        }else{
            return Math.min(
                    Math.min(len - botTop, len - botBot),
                    Math.min(len - topTop, len - topBot)
            );
        }
    }


}
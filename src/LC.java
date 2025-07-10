import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}


class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] prefix = new int[len], postfix = new int[len];
        for (int i = 0; i < height.length; i++) {
            if (i - 1 >= 0) {
                prefix[i] = Math.max(height[i], prefix[i - 1]);
            } else {
                prefix[i] = height[i];
            }
        }
        for (int i = len - 1; i >= 0; --i) {
            if (i + 1 < len) {
                postfix[i] = Math.max(postfix[i + 1], height[i]);
            } else {
                postfix[i] = height[i];
            }
        }
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int high = Math.min(prefix[i - 1], postfix[i + 1]);
            if (high>height[i]){
                ans+=high-height[i];
            }
        }
        return ans;
    }
}
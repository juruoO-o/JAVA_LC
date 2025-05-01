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
        new Solution().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);

    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            ans[i]=1;
            for(int j=i-1;j>0;--j){
                ans[j] +=ans[j-1];
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
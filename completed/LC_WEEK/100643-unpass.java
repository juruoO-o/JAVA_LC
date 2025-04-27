import java.util.*;
import java.util.List;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] obs = new int[][]{
                {2, 2}
        };
        List<Integer> nums = new ArrayList<>();
        new Solution().concatenatedDivisibility(new int[]{3,12,45},5);

    }
}


class Solution {
    boolean[] visit;
    int[] ans;
    boolean ok = false;

    public int[] concatenatedDivisibility(int[] nums, int k) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        ans = new int[nums.length];
        rec(nums,0,k,0);
        if (ok)
            return ans;
        else
            return new int[0];
    }

    void rec(int[] nums, int level, int k,int carry) {
        if (ok){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ok){
                return;
            }
            if (!visit[i] ){
                visit[i]=true;
                ans[level]=nums[i];
                int num = Integer.valueOf(String.valueOf(carry)+String.valueOf(nums[i]));
                num%=k;
                if (level==nums.length-1 && num==0 ){
                    ok=true;
                }
                rec(nums,level+1,k,num);
                visit[i]=false;
            }
        }
    }
}
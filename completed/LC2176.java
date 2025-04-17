import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().countPairs(new int[]{3,1,2,2,2,1,3},2);

    }
}


class Solution {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int ans = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                for (int j = i+1; j < value.size(); j++) {
                    if((value.get(i)*value.get(j))%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
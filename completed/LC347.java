import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3, 4};
        String s = "-2+ 1";
        int[][] interval = {
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        };
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {4,1,-1,2,-1,2,3};
        new Solution().topKFrequent(height,2);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(k,(a,b)->a.cnt-b.cnt);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new pair(entry.getKey(),entry.getValue()));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]= pq.poll().num;
        }
        return ans;
    }
    class pair{
        int num;
        int cnt;
        pair(int a,int b){
            num=a;
            cnt=b;
        }
    }
}
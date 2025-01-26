import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5, 25, 24, 5};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution();
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len-2; ++i) {
            for (int j = i + 1; j < len-1; ++j) {
                int idx = Arrays.binarySearch(nums, j + 1, len, -nums[i] - nums[j]);
                if (idx>=0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[idx]);
                    ans.add(tmp);
                }
                while (j<len-1 && nums[j]==nums[j+1]) ++j;
            }
            while (i<len-2 && nums[i]==nums[i+1]) ++i;
        }
        return ans;
    }
}
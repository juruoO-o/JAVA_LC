import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().minWindow("bbaac", "aba");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum>ans){
                ans=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return ans;
    }
}
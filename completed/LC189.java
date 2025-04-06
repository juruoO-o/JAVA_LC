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
        int [][] interval = {
                {1,3},{8,10},{15,18},{2,6}
        };
        new Solution().merge(interval);
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        reverse(nums,0,len-k);
        reverse(nums,len-k,len);
        reverse(nums,0,len);
    }
    void reverse(int[] nums,int start,int end){
        int tmp;
        end--;
        while (start<end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5, 25, 24, 5};
        int[] nums2 = {1, 1, 1};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().subarraySum(nums2, 2);
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int cnt=0,sum=0;
        int ans=0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            Integer i1 = map.get(sum - k);
            if(i1!=null){
                ans+=i1;
            }
            Integer i2 = map.get(sum);
            if (i2==null){
                map.put(sum,1);
            }else{
                map.put(sum,i2+1);
            }
        }
        return ans;
    }
}
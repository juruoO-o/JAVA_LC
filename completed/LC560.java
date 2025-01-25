import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        List<String> str = new ArrayList<>();
        str.add("dog");
        str.add("s");
        str.add("gs");
        new Solution().subarraySum(nums2, );
        System.out.println("abc".compareTo("ab"));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer res = map.get(sum - k);
            ans += res == null ? 0 : res;
            Integer cnt = (map.get(sum);
            if (cnt == null) {
                map.put(sum, 1);
            } else {
                map.put(sum, cnt + 1);
            }
        }
        return ans;
    }
}
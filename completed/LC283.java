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
    public void moveZeroes(int[] nums) {
        int noneZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[noneZero] = nums[i];
                noneZero++;
            }
        }
        for (int i=noneZero;i< nums.length;i++){
            nums[i]=0;
        }
    }
}
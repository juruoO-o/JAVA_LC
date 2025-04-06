import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.awt.image.AreaAveragingScaleFilter;
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
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {1, 2, 87, 87, 87, 2, 1};

        new Solution().reverseWords("the sky is blue");
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = new char[s.length()];
        int left=0;
        int right=0;
        for(char c : s.toCharArray()){
            if (c>='a' && c<='z'||c>='0' && c<='9'){
                arr[right++]=c;
            }else if (c>='A' && c<='Z'){
                arr[right++] = (char)('a'+c-'A');
            }
        }
        right--;
        while (left<=right){
            if (arr[left]!=arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
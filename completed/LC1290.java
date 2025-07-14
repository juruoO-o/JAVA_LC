import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}


class Solution {
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while (head!=null){
            ans<<=1;
            ans|= head.val;
            head=head.next;
        }
        return ans;
    }
}
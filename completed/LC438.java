import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5, 25, 24, 5};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().findAnagrams("baa", "aa");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length(), plen = p.length();
        if (plen>len) {
            return ans;
        }
        int[] cnt = new int[26];
        int notZero = 0;
        for (int i = 0; i < plen; i++) {
            int key = p.charAt(i) - 'a';
            if (cnt[key] == 0) {
                notZero++;
            }
            cnt[key]++;
            if (cnt[key] == 0) {
                notZero--;
            }
            key = s.charAt(i) - 'a';
            if (cnt[key] == 0) {
                notZero++;
            }
            cnt[key]--;
            if (cnt[key] == 0) {
                notZero--;
            }
        }
        if (notZero == 0) {
            ans.add(0);
        }
        for (int i = 0; i < len - plen; i++) {

            int key = s.charAt(i) - 'a';
            if (cnt[key] == 0) {
                notZero++;
            }
            cnt[key]++;
            if (cnt[key] == 0) {
                notZero--;
            }
            key = s.charAt(i + plen) - 'a';
            if (cnt[key] == 0) {
                notZero++;
            }
            cnt[key]--;
            if (cnt[key] == 0) {
                notZero--;
            }
            if (notZero == 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
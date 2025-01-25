import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 2, 3};
        String s = "-2+ 1";
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        String string = new Codec().serialize(root);
        TreeNode newRoot = new Codec().deserialize(string);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str:strs){
            int[] cnt = new int[26];
            for (char c:str.toCharArray()){
                cnt[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                sb.append(cnt[i]);
                sb.append(",");
            }
            String key = sb.toString();
            sb.delete(0,sb.length());
            if (map.get(key)==null){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

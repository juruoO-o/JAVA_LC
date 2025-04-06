import java.lang.classfile.instruction.CharacterRange;
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
        TreeNode root = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] arr1 = {{1, 3}};
        int[] height = {2, 3, 1, 1, 4};
        new Solution().partitionLabels("ababcbacadefegdehijhklij");


    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        pair[] arr = new pair[26];
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len; i++) {
            int idx = str[i] - 'a';
            if (arr[idx] == null) {
                arr[idx] = new pair(i, i);
            } else {
                arr[idx].last = i;
            }
        }
        Arrays.sort(arr, (a, b) -> {
            if (a==null){
                return -1;
            }
            if (b==null){
                return 1;
            }
            return a.first - b.first == 0 ? a.last - b.last : a.first - b.first;
        });
        int curStart = -1;
        int curEnd = -1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == null) {
                continue;
            } else {
                if (curStart == -1) {
                    curStart = arr[i].first;
                    curEnd = arr[i].last;
                }else if (arr[i].first>curEnd){
                    ans.add(curEnd-curStart+1);
                    curStart=arr[i].first;
                    curEnd = arr[i].last;
                }else{
                    curEnd = Math.max(curEnd,arr[i].last);
                }
            }
        }
        ans.add(curEnd-curStart+1);
        return ans;
    }

    class pair {
        int first;
        int last;

        pair(int a, int b) {
            first = a;
            last = b;
        }
    }
}
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
        int i = new Solution().pathSum(root, 0);
        System.out.println(i);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr = new List[numCourses];
        int[] inDegeree = new int[numCourses];
        for (int[] pair:prerequisites){
            if (arr[pair[1]]==null){
                arr[pair[1]] = new ArrayList<>();
            }
            arr[pair[1]].add(pair[0]);
            inDegeree[pair[0]]++;
        }
        boolean flag=true;
        while (flag){
            flag=false;
            for (int i = 0; i < numCourses; i++) {
                if (inDegeree[i]==0){
                    flag= true;
                    inDegeree[i]--;
                    if (arr[i]!=null){
                        for (int out:arr[i]){
                            inDegeree[out]--;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegeree[i]>0)
                return false;
        }
        return true;
    }
}
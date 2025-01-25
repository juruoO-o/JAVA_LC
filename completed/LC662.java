//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.lang.invoke.TypeDescriptor;
import java.security.PrivilegedAction;
import java.util.*;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Solution().searchMatrix(nums, 5);
    }
}


class Solution {
    List<Integer> max,min;
    public int widthOfBinaryTree(TreeNode root) {
        max = new ArrayList<>();
        min = new ArrayList<>();
        traversal(root,0,0);
        int ans=0;
        for (int i = 0; i < max.size(); i++) {
            ans = Math.max(ans,max.get(i)-min.get(i));
        }
        return ans+1;
    }
    void traversal(TreeNode root,int height,int num){
        if (max.size()==height){
            max.add(num);
            min.add(num);
        }else{
            max.set(height,num);
        }
        if(root.left!=null){
            traversal(root.left,height+1,num*2);
        }
        if(root.right!=null){
            traversal(root.right,height+1,num*2+1);
        }
    }
}
import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.management.ListenerNotFoundException;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {2, 5};
        List<String> strs = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        new Solution().ladderLength("hit", "cog", strs);
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(4, 10,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        tpe.sub
    }
}

class Solution {
    class pair<F, S> {
        F first;
        S second;

        pair(F f, S s) {
            first = f;
            second = s;
        }
    }

    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<pair<Node,Integer>> q = new LinkedList<>();
        q.add(new pair<>(root,0));
        while (!q.isEmpty()){
            pair<Node, Integer> poll = q.poll();
            if (!q.isEmpty()){
                pair<Node, Integer> peek = q.peek();
                if (poll.second.equals(peek.second)){
                    poll.first.next = peek.first;
                }
            }
            if (poll.first.left!=null){
                q.add(new pair<>(poll.first.left, poll.second+1));
            }
            if (poll.first.right!=null){
                q.add(new pair<>(poll.first.right, poll.second+1));
            }
        }
        return root;
    }
}
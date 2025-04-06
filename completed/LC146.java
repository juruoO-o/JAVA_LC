import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.management.ListenerNotFoundException;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.classfile.instruction.CharacterRange;
import java.nio.charset.StandardCharsets;
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
        int[][] arr1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[] height = {2, 5};
        String[] strs = {"word", "good", "best", "word"};
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);

    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Integer> mp;
    private LinkedList<Integer> q;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>(capacity);
        q = new LinkedList<>();
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            q.remove(Integer.valueOf(key));
            q.addFirst(key);
            return mp.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)){
            mp.put(key,value);
            q.remove(Integer.valueOf(key));
            q.addFirst(key);
        }
        else {
            if (mp.size() == capacity) {
                int del = q.pollLast();
                mp.remove(del);
            }
            mp.put(key, value);
            q.addFirst(key);
        }
    }
}

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
        int[] height = {5, 2, 3, 1};

        new Solution();
    }
}

class RandomizedSet {
    Set<Integer> set;
    Iterator<Integer> iterator;
    Random random;
    public RandomizedSet() {
        set = new HashSet<>();
        iterator = set.iterator();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!set.contains(val)){
            set.add(val);
            return true;
        }else{
            return false;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)){
            set.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        Object[] arr = set.toArray();
        return (Integer) arr[random.nextInt(arr.length)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
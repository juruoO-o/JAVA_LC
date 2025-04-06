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
        int[] height = {4,1,-1,2,-1,2,3};
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();

    }
}

class MedianFinder {
    PriorityQueue<Integer> pqbig = new PriorityQueue<>((a,b)->a-b);
    PriorityQueue<Integer> pqsmall = new PriorityQueue<>((a,b)->b-a);
    int cnt=0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        cnt++;
        if (pqbig.size()==0){
            pqbig.add(num);
        }else if (pqsmall.size()==0){
            int left = pqbig.peek();
            if (left<num){
                pqsmall.add(num);
            }else{
                pqbig.poll();
                pqbig.add(num);
                pqsmall.add(left);
            }
        }else{
            int left = pqbig.peek();
            int right = pqsmall.peek();
            if (cnt%2==0){
                if (num>left){
                    pqsmall.add(num);
                }else{
                    pqbig.poll();
                    pqbig.add(num);
                    pqsmall.add(left);
                }
            }else{
                if (num<right){
                    pqbig.add(num);
                }else{
                    pqsmall.poll();
                    pqsmall.add(num);
                    pqbig.add(right);
                }
            }
        }
    }

    public double findMedian() {
        if (cnt%2==1){
            return pqbig.peek();
        }else{
            return (pqbig.peek()+pqsmall.peek())/2.0;
        }
    }
}
import javax.management.relation.InvalidRelationTypeException;
import javax.print.attribute.standard.PrinterURI;
import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Parameter;
import java.util.*;

public class LC {
    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] nums = {8, 8};
        int[][] obs = new int[][]{
                {2, 2}
        };
        new Solution().myPow(2.0, -2147483648);

    }
}


class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans=0;
        int tmp ;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i]-arr[j])>a){
                    continue;
                }
                for (int k = j+1; k < arr.length; k++) {
                    if (Math.abs(arr[i]-arr[j])<=a &&
                            Math.abs(arr[k]-arr[j])<=b &&
                            Math.abs(arr[i]-arr[k])<=c){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
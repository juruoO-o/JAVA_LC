//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

import java.util.concurrent.Semaphore;

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class LC {
    static volatile Semaphore a = new Semaphore(1);
    static volatile Semaphore b = new Semaphore(0);
    static volatile Semaphore c = new Semaphore(0);
    static volatile int n = 10;

    public static void main(String[] args) throws InterruptedException {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {
                -1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[] loc = new Solution().getLoc(6, 6, 36);
        System.out.println(loc[0]);
        System.out.println(loc[1]);
        int cnt = 0;
        

    }
}

class Pair<F, S> {
    F first;
    S second;

    Pair(F f, S s) {
        first = f;
        second = s;
    }
}

class Solution {
    int ans=-1;
    public int snakesAndLadders(int[][] board) {
        bfs(board, board.length, board[0].length,0,1);
        return ans;
    }

    void bfs(int[][] board, int m, int n, int loc,int step) {
        if (loc == m*n ){
            ans = Math.min(ans,step);
        }
        for (int i = 1; i <= 6 && loc + i <= m * n; i++) {
            int newLoc = loc+i;
            int[] xy = getLoc(m,n,newLoc);
            if (board[xy[0]][xy[1]]==-1){
                bfs(board,m,n,newLoc,step+1);
            }else{
                bfs(board,m,n,board[xy[0]][xy[1]],step+1);
            }
        }
    }

    int[] getLoc(int m, int n, int num) {
        num--;
        int[] ret = new int[2];
        ret[0] = m - num / n - 1;
        ret[1] = num % n;
        if ((m - ret[0]) % 2 == 0) {
            ret[1] = n - 1 - ret[1];
        }
        return ret;
    }
}
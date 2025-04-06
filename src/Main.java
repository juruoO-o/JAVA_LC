import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] tree = new int[n + 1];
        List<List<Integer>> red = new ArrayList<>();
        int u, v, w, c;
        int unique = n;
        int sum = 0;
        while (m-- > 0) {
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();
            c = in.nextInt();
            if (c == 1) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(w);
                red.add(edge);
                sum += w;
            } else {
                while (tree[u] != 0) {
                    u = tree[u];
                }
                while (tree[v] != 0) {
                    v = tree[v];
                }
                if (u != v) {
                    tree[v] = u;
                    unique--;
                }
            }
        }
        red.sort((a, b) -> a.get(2) - b.get(2));
        int[] ans = new int[n + 1];
        for (int i = unique; i <= n; i++) {
            ans[i] = sum;
        }
        for (var edge : red) {
            u = edge.get(0);
            v = edge.get(1);
            while (tree[u] != 0) {
                u = tree[u];
            }
            while (tree[v] != 0) {
                v = tree[v];
            }
            if (u != v) {
                unique--;
                sum -= edge.get(2);
                tree[v]=u;
                ans[unique] = sum;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
    }
}

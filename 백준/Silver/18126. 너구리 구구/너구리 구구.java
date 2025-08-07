import java.util.*;
public class Main {

    static long ret;
    static List<Node>[] adj;
    static int[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adj = new ArrayList[n + 1];
        vis = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }

        go(1);
        System.out.println(ret);
    }

    public static void go(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            var node = q.poll();
            ret = Math.max(ret, node.value);
            vis[node.adj] = 1;
            for(Node there : adj[node.adj]){
                if (vis[there.adj] != 0) continue;
                there.value += node.value;
                q.add(there);
            }
        }
    }

    public static class Node{
        int adj;
        long value;

        public Node(int adj, long value) {
            this.adj = adj;
            this.value = value;
        }
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if (pos == m) break;
            int[] move = {pos - 1, pos + 1, pos * 2};
            for (int i = 0; i < 3; i++) {
                if (move[i] < 0 || move[i] > 100000) continue;
                if (visited[move[i]] != 0) continue;
                queue.add(move[i]);
                visited[move[i]] = visited[pos] + 1;
            }
        }
        System.out.println(visited[m] - 1);
    }
}

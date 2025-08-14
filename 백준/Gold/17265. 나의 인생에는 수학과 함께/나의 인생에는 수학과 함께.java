import java.util.*;
public class Main {
    static char[][] C;
    static int[][] vis;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        C = new char[n][n];
        vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = sc.next().charAt(0);
                C[i][j] = c;
            }
        }

        stack.add(C[0][0] - '0');
        dfs(0, 0);
        System.out.println(max + " " + min);
    }

    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static Stack<Integer> stack = new Stack<>();
    private static void dfs(int y, int x) {
        vis[y][x] = 1;

        if (y == n - 1 && x == n - 1) {
            min = Math.min(stack.peek(), min);
            max = Math.max(stack.peek(), max);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (vis[ny][nx] == 1) continue;

            //다음 값이 숫자면
            if (Character.isDigit(C[ny][nx])) {
                char op = C[y][x]; // 현재 위치는 operator
                int pre = stack.peek(); // 이전값
                int next = C[ny][nx] - '0'; // 다음값

                int value;
                if (op == '+')
                    value = pre + next;
                else if (op == '-')
                    value = pre - next;
                else
                    value = pre * next;

                stack.push(value);
                dfs(ny, nx);
                stack.pop(); // 숫자 칸으로 들어갈 때만 push/pop
            } else {
                // 연산자 칸은 계산/스택 조작 없음
                dfs(ny, nx);
            }
            vis[ny][nx] = 0;
        }
    }
}

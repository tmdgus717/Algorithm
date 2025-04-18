import java.util.*;
import java.io.*;
public class Main {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    static int[][] arr;
    static int[][] vis;
    static int total;
    static List<Position> positions = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int count = 0;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //max : 5000000
        while (true) {
            if (flag) break; //종료조건 만족
            flag = true; //종료조건 초기값
            vis = new int[n][n];
            count++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(vis[i][j] != 0) continue;
                    total = 0;
                    dfs(i, j, n, l, r);
                    total /= positions.size();
                    for (Position position : positions) {
                        arr[position.y][position.x] = total;
                    }
                    positions.clear();
                }
            }//for
        }//while
        System.out.println(count - 1); //처음에 무조건 한번 증가하기 때문에 -1
    }

    private static void dfs(int y, int x, int n, int l, int r) {
        positions.add(new Position(y, x));
        total += arr[y][x];
        vis[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if (vis[ny][nx] != 0) {
                continue;
            }
            int abs = Math.abs(arr[y][x] - arr[ny][nx]);
            if (abs < l || abs > r) {
                continue;
            }
            flag = false; //종료하면안됨
            dfs(ny,nx,n,l,r);
        }
    }

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

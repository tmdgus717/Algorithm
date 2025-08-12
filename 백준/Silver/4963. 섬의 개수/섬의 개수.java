import java.io.*;
import java.util.*;
public class Main {

    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[][] arr = new int[n][m];
            int[][] vis = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && vis[i][j] == 0){
                        dfs(i, j, arr, vis, n, m);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int y, int x, int[][] arr, int[][] vis, int n, int m) {
        vis[y][x] = 1;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (vis[ny][nx] == 1) continue;
            if (arr[ny][nx] == 0) continue;
            dfs(ny, nx, arr, vis, n, m);
        }
    }
}

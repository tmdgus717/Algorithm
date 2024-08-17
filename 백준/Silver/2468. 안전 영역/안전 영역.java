import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {//2468
    static int n;
    static int[][] arr;
    static int[][] vis;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//배열 초기화

        int answer = 0;
        for (int t = 0; t <= 100; t++) { //t가 물높이
            int ret = 0;
            vis = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] > t && vis[i][j] == 0){
                        dfs(i,j,t);
                        ret++;
                    }
                }
            }
            answer = Math.max(answer, ret);
        }
        //출력
        System.out.println(answer);
    }

    static void dfs(int y, int x, int t) {
        vis[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (arr[ny][nx] <= t || vis[ny][nx] == 1) continue;
            dfs(ny, nx, t);
        }//for
    }//dfs
}

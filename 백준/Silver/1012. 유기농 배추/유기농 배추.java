import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{//connected component?? > dfs??
    static int[][] arr;
    static int[][] vis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) { //테스트 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); //가로
            int n = Integer.parseInt(st.nextToken()); //세로
            int k = Integer.parseInt(st.nextToken()); //배추의 수
            arr = new int[n][m]; //0으로 초기화
            vis = new int[n][m];
            while (k-- > 0) {//배추 수 만큼 반복
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }//배추 위치 설정
            int ans = 0;
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < m; column++) {
                    if(arr[row][column] == 1 && vis[row][column] == 0){//배추가 있고 방문하지 않았다면
                        dfs(row,column,n,m);
                        ans++;
                    }
                }
            }//for
            System.out.println(ans);
        }
    }// main

    static void dfs(int y, int x, int n, int m) {

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        vis[y][x] = 1; //방문 설정
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (arr[ny][nx] == 0) continue; //배추없으면 방문안해요
            if (vis[ny][nx] != 0) continue; //이미 배추가 있어도 방문 안해요 필요한가?
            dfs(ny, nx, n, m); //주변 방문 처리
        }
    }
}

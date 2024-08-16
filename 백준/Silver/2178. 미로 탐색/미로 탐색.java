import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
public class Main {//2178
    //최소 칸의 수? 가중치가 같은 최단거리 문제 > bfs??
    static int[][] arr;
    static int[][] vis;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }//배열 초기화
        //bfs
        Queue<Pair> queue = new LinkedList<>();
        //시작 노드 넣는
        queue.add(new Pair(0,0));
        vis[0][0] = 1;
        while(!queue.isEmpty()){
            Pair tmp = queue.poll();
            int y = tmp.y;
            int x = tmp.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (arr[ny][nx] != 1) continue; //길이 아니면 패스
                if (vis[ny][nx] > 0) continue; //이미 방문했으면 패스
                //방문할 위치 정보를 큐에 넣는다
                queue.add(new Pair(ny,nx));
                //방문할 위치 정보에 가중치를 추가한다. 가중치는 한칸
                vis[ny][nx] = vis[y][x] + 1;
            }
        }
        System.out.println(vis[n-1][m-1]);
    }//main

    static class Pair{
        int x;
        int y;
        Pair(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}

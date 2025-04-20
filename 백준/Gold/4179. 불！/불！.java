import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * #: 벽
 * .: 지나갈 수 있는 공간
 * J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
 * F: 불이 난 공간
 * J는 입력에서 하나만 주어진다.
 */
public class Main {

    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static char[][] arr;
    static int[][] vis;
    static int[][] fireVis;
    static int n;
    static int m;
    static int answer;
    static Queue<Position> fires = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int del = s.indexOf(" ");
        n = Integer.parseInt(s.substring(0, del)); // max 1000
        m = Integer.parseInt(s.substring(del + 1)); //max 1000
        int jy = 0;
        int jx = 0;

        //지도 생성
        arr = new char[n][m];
        fireVis = new int[n][m];
        vis = new int[n][m];
        //fireVis 맥스값으로 생성
        for (int i = 0; i < n; i++) {
            Arrays.fill(fireVis[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
                if (c == 'F') {
                    fires.add(new Position(i, j));
                    fireVis[i][j] = 1;
                }
                if(c == 'J'){
                    vis[i][j] = 1;
                    jy = i;
                    jx = j;
                }
            }
        }

        //불을 퍼트린다
        fireBfs();

        //지훈이 출발
        go(jy, jx);

        //출력
        if (answer == 0) {
            System.out.println(IMPOSSIBLE);
        }else{
            System.out.println(answer);
        }
    }

    private static void go(int y, int x) {
        if (y == 0 || x == 0 || y == n - 1 || x == m - 1) {
            answer = vis[y][x];
            return;
        }
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x));

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = position.y + dy[i];
                int nx = position.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m ) {
                    continue;
                }
                if (arr[ny][nx] == '#' || vis[ny][nx] != 0) continue;
                if (fireVis[ny][nx] <= vis[position.y][position.x] + 1) continue;
                if (ny == 0 || nx == 0 || ny == n - 1 || nx == m - 1) {
                    answer = vis[position.y][position.x] + 1;
                    return;
                }

                //bfs 가중치가 1인 최단 거리 값
                vis[ny][nx] = vis[position.y][position.x] + 1;
                queue.add(new Position(ny, nx));
            }
        }
    }

    private static void fireBfs() {
        while (!fires.isEmpty()) {
            Position position = fires.poll();
            for (int i = 0; i < 4; i++) {
                int ny = position.y + dy[i];
                int nx = position.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == '#') {
                    continue;
                }
                if ( fireVis[ny][nx] <= fireVis[position.y][position.x] + 1){
                    // 더 빨리 온 불이 있다면 continue;
                    continue;
                }
                fireVis[ny][nx] = fireVis[position.y][position.x] + 1;
                fires.add(new Position(ny, nx));
            }
        }
    }

    static class Position{
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

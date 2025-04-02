import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //연구소
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] vis;
    static int count = 0;
    static int answer = 0;
    static List<Position> virus = new ArrayList<>();
    static List<Position> emptySpace = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //지도 그리기
        arr = new int[n][m];
       for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if (tmp == 2) { //바이러스 위치 저장
                    virus.add(new Position(i, j));
                }
                if (tmp == 0) {
                    emptySpace.add(new Position(i, j));
                }
            }
        }

       for (int i = 0; i < emptySpace.size(); i++) {
           for (int j = 0; j < i; j++) {
               for (int k = 0; k < j; k++){
                   //벽을 세개 세운다
                   arr[emptySpace.get(i).y][emptySpace.get(i).x] = 1;
                   arr[emptySpace.get(j).y][emptySpace.get(j).x] = 1;
                   arr[emptySpace.get(k).y][emptySpace.get(k).x] = 1;
                   solve(n,m);
                   //다시 벽 초기화
                   arr[emptySpace.get(i).y][emptySpace.get(i).x] = 0;
                   arr[emptySpace.get(j).y][emptySpace.get(j).x] = 0;
                   arr[emptySpace.get(k).y][emptySpace.get(k).x] = 0;
               }
           }
       }

        //출력
        System.out.println(answer);
    }//main

    private static void solve(int n,int m) {
        vis = new int[n][m];
        //바이러스 퍼트리기
        for (Position vp : virus) {
            vdfs(vp.y, vp.x, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //arr에서 바이러스가 아니고 벽이아니고 vis 방문하지 않았다면
                if (arr[i][j] == 0 && vis[i][j] == 0){
                    findSafeArea(i, j, n, m);
                }
            }
        }

        //max 값 구하기
        answer = Math.max(answer, count);
        count = 0;
    }

    private static void findSafeArea(int y, int x, int n, int m) {
        vis[y][x] = 1; //방문
        count ++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                //경계 밖으로 나가면
                continue;
            }
            if (arr[ny][nx] != 0) {
                //arr 이 바이러스나 벽이면 컨티뉴
                continue;
            }
            if(vis[ny][nx] != 0){
                //방문하지 않은 장소가 아니면
                continue;
            }
            findSafeArea(ny, nx, n, m);
        }
    }

    public static void vdfs(int y, int x, int n, int m) {
        vis[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                //경계 밖으로 나가면
                continue;
            }
            if (arr[ny][nx] != 0) {
                //빈 공간이 아니면
                continue;
            }
            if (vis[ny][nx] != 0) {
                //바이러스가 방문하지 않은 곳이 아니면
                continue;
            }

            vdfs(ny, nx, n, m);
        }
    }//vdfs

    static class Position{
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }//class position
}

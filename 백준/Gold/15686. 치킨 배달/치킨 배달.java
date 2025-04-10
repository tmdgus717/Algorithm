import java.util.*;
import java.io.*;
public class Main {

    static int totalDistance = Integer.MAX_VALUE;
    static int least = 0;
    static int[][] arr;
    static int[][] vis;
    static int[][] answer;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    static int m;
    static int step = 0;
    static List<Position> chickens = new ArrayList<>();
    static List<Position> remains = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //정사각형
        m = Integer.parseInt(st.nextToken());

        //==치킨집 빼고 지도그리기==//
        arr = new int[n][n];
        vis = new int[n][n];
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    chickens.add(new Position(i, j));
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = value;
            }
        }

        //==치킨집 M개를 고르고 치킨거리는 가장 작게==//
        run(0);

        //==치킨거리 최소값 출력==//
        System.out.println(totalDistance);
    }

    static void run(int idx){
        if(remains.size() == m){
            go();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 1){
                        least += answer[i][j];
                    }
                }
            }

            answer = new int[n][n];
            totalDistance = Math.min(totalDistance, least);
            least = 0;
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            Position position = chickens.get(i);
            remains.add(position);
            arr[position.y][position.x] = 2;
            run(i + 1);
            remains.remove(remains.size() - 1);
            arr[position.y][position.x] = 0; //원복
        }
    }

    //==사람 위치에서 돌면서 가장 가까운 치킨집 탐색==//
    static void go() {
        for (Position position : remains) {
            vis = new int[n][n];
            Queue<Position> queue = new LinkedList<>();
            queue.add(position);
            while (!queue.isEmpty()){
                Position p = queue.poll();
                int y = p.y;
                int x = p.x;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if (vis[ny][nx] != 0) continue;

                    vis[ny][nx] = vis[y][x] + 1;
                    if (arr[ny][nx] == 1){
                        if (answer[ny][nx] == 0){
                            answer[ny][nx] = vis[ny][nx];
                        }
                        else if (vis[ny][nx]<answer[ny][nx]){
                            answer[ny][nx] = vis[ny][nx];
                        }
                    }
                    queue.add(new Position(ny, nx));
                }
            }
        }
    }

    static class Position{
        int y;
        int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

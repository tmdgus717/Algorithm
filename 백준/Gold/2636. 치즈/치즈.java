import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] vis;
    static int cheese = 0;
    static Queue<Position> deletedCheese = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //세로 max : 100
        int m = Integer.parseInt(st.nextToken()); //가로 max : 100
        int time = 0;
        int size = 0;

        //===지도생성===//
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if (value == 1) {
                    cheese++;
                }
            }
        }

        while (true) {
            time++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        //===치즈가 있으면 판단 시작===//
                        go(i, j, n, m);
                    }
                }
            }

            cheese -= deletedCheese.size();//치즈 개수 삭제

            //===치즈가 없다면 이전 치즈 사이즈 출력===//
            if (cheese == 0) {
                size = deletedCheese.size();
                break;
            }

            //===지워진 치즈로 지도 업데이트===//
            while (!deletedCheese.isEmpty()) {
                Position position = deletedCheese.poll();
                arr[position.y][position.x] = 0;
            }
        }

        //===시간,치즈사이즈 출력===//
        System.out.println(time);
        System.out.println(size);
    }//main

    private static void go(int y, int x, int n, int m) {
        //일단 빈 공간이 있는지 확인
        int ny;
        int nx;
        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            if(arr[ny][nx] == 0) {
                //빈공간이 있다면 공기가 있는지 확인
                vis = new int[n][m];
                if(hasAir(ny, nx, n, m)){ //공기가 있다면
                    deletedCheese.add(new Position(y, x));
                    break;
                }
            }
        }
    }

    private static boolean hasAir(int y, int x, int n, int m) {
        boolean isAir = false;
        if (y == 0 || x == 0 || y == n - 1 || x == m - 1) {
            return true;
        }
        vis[y][x] = 1;
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx <0 || ny >= n || nx >= m) continue; //범위를 넘으면
            if(arr[ny][nx] == 1) continue;
            if(vis[ny][nx] == 1) continue;
            isAir = hasAir(ny, nx, n, m);
            if(isAir) break; //공기를 찾았다면 함수 for 문 종료
        }
        return isAir;
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

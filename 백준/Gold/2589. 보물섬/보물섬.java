import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int m;
    static char[][] arr;
    static int[][] vis;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        //==지도 초기화==//
        arr = new char[n][m];
        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    vis=new int[n][m];
                    go(i, j);
                }
            }
        }

        System.out.println(max - 1);

    }//main

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static void go(int y, int x) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x));
        vis[y][x] = 1;
        while(!queue.isEmpty()){
            Position position = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = position.y + dy[dir];
                int nx = position.x + dx[dir];

                //==경계를 벗어나면 패스==//
                if(ny < 0 || nx < 0 || ny >=n || nx >= m) continue;
                //==바다이거나 이미 방문했다면 패스==//
                if(arr[ny][nx] == 'W' || vis[ny][nx] != 0) continue;
                vis[ny][nx] = vis[position.y][position.x] + 1;
                max = Math.max(max,vis[ny][nx]);
                queue.add(new Position(ny, nx));
            }
        }
    }

    //==Position==//
    static class Position{
        int y;
        int x;

        Position(int y, int x) {

            this.y = y;
            this.x = x;
        }
    }//Position
}

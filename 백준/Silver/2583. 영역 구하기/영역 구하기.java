//package chapter02;

import java.io.*;
import java.util.*;
public class Main {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //Y
        int N = Integer.parseInt(st.nextToken()); //X
        int K = Integer.parseInt(st.nextToken()); //직사각형 수

        arr = new int[M][N];
        vis = new int[M][N];

        //지도 만들기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int ldx = Integer.parseInt(st.nextToken());
            int ldy = Integer.parseInt(st.nextToken());
            int rux = Integer.parseInt(st.nextToken());
            int ruy = Integer.parseInt(st.nextToken());

            for (int j = ldy; j < ruy; j++) {
                for (int k = ldx; k < rux; k++) {
                    arr[M-1-j][k] = 1; //그림이랑 똑같이 넣기
                }
            }
        }

        int count = 0; //영역 수
        List<Integer> areas = new ArrayList<>();
        //영역의 수와 넓이 구하는 로직
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 0) continue; //벽이면 continue
                if(vis[i][j] == 1) continue; //방문했으면 continue
                count++;
                //dfs 를 돌면서
                areas.add(dfs(i, j, N, M));
            }
        }

        //출력
        System.out.println(count);
        //areas 정렬
        Collections.sort(areas);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }//main

    static public int dfs(int y, int x, int n, int m) {
        vis[y][x] = 1; //방문 먼저 하기
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n) {
                continue;
            }
            if (arr[ny][nx] == 1 || vis[ny][nx] == 1) {
                continue;
            }//벽이거나 방문했으면 패스

            area += dfs(ny, nx, n, m);
        }
        return area;
    }
}

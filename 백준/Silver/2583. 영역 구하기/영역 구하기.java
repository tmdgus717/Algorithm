import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {//2583
    static int[][] arr;
    static int[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        int m = Integer.parseInt(st.nextToken()); //세로
        int n = Integer.parseInt(st.nextToken()); //가로
        int k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        vis = new int[m][n];
        while (k-- > 0) {
            //직사각형 색칠하기
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    arr[i][j] = 1;
                }
            }
        }//while
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0 && vis[i][j] == 0){
                    dfs(i, j, m, n);
                    ans++;
                    arrayList.add(size);
                    size=0;
                }
            }
        }
        System.out.println(ans);
        arrayList.sort(Comparator.naturalOrder());
        for (int num : arrayList) {
            System.out.print(num + " ");
        }
    }//main

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int size = 0;
    static void dfs(int y, int x, int m, int n) {
        vis[y][x] = 1;
        size++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
            if(arr[ny][nx] != 0 || vis[ny][nx] == 1) continue;
            dfs(ny, nx, m, n);
        }
    }
}

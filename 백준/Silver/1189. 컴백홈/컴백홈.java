import java.util.*;
public class Main {

    private static int r,c,k,count;
    private static char[][] map;
    private static int[][] vis;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();// 3
        c = sc.nextInt();// 4
        k = sc.nextInt();// 6
        sc.nextLine();
        map = new char[r][c];
        vis = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < c; j++) {
                char tmp = s.charAt(j);
                map[i][j] = tmp;
            }
        }

        vis[r-1][0] = 1;
        dfs(r-1,0);

        System.out.println(count);
    }

    private static void dfs(int y,int x){
        if (y == 0 && x == c - 1){
            if (vis[y][x] == k) count++;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny > r-1 || nx > c - 1) continue;
            if (vis[ny][nx] != 0) continue;
            if (map[ny][nx] == 'T') continue;

            vis[ny][nx] = vis[y][x] + 1;
            dfs(ny, nx);
            vis[ny][nx] = 0;
        }
    }
}

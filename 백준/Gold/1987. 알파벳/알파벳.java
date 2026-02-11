//알파벳
import java.util.*;
public class Main {
    static int r,c;
    static boolean[] visited = new boolean[26];
    static int[][] arr;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); //행
        c = sc.nextInt(); //열
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
               arr[i][j] = str.charAt(j) - 'A';
            }
        }
        go(0, 0, 1);
        System.out.println(answer);
    }
    static int answer = 0;
    static void go(int y, int x, int count){
        visited[arr[y][x]] = true; // 방문
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if (visited[arr[ny][nx]]) continue;
            go(ny,nx,count+1);
            visited[arr[ny][nx]] = false;
        }
        answer = Math.max(answer, count);
    }
}

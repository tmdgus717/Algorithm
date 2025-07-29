import java.util.*;
public class Main {

    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        go(0, 0, n);
        System.out.println(sb);
    }

    public static void go(int y,int x, int n) {
        int flag = arr[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (flag != arr[i][j]) {
                    sb.append("(");
                    go(y, x, n / 2);
                    go(y, x + n / 2, n / 2);
                    go(y + n / 2, x, n / 2);
                    go(y + n / 2, x + n / 2, n / 2);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(flag);
    }
}

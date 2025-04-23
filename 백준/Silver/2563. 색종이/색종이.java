import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            //그려지는 위치는 상하 뒤집히지만 넓이 구하기에는 상관없음
            for (int j = bottom; j < bottom + 10; j++) {
                for (int k = left; k < left + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(arr[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }

}

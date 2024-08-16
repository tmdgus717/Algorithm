import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//2979
    static int[] time = new int [101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //요금
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int t = 0; t < 3; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = n; i < m; i++) {
                time[i]++;
            }
        }

        int ans = 0;
        for (int carNum : time) {
            if(carNum == 1){
                ans += a;
            }
            if (carNum == 2){
                ans += (b * 2);
            }
            if (carNum == 3) {
                ans += (c * 3);
            }
        }
        System.out.println(ans);
    }
}

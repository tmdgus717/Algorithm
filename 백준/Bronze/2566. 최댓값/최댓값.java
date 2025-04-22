import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int y = -1;
        int x = -1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp > max) {
                    max = tmp;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(max);
        System.out.printf("%d %d\n", y + 1, x + 1);
    }

}

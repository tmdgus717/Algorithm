import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //n,x
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //1~10000
        int x = Integer.parseInt(st.nextToken()); //1~10000
        st = new StringTokenizer(br.readLine());

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (x > tmp) {
                sb.append(tmp).append(" ");
            }
        }

        System.out.println(sb);
    }

}

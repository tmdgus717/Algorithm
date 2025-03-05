import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] parking = new int[100];
        int a = Integer.parseInt(st.nextToken());
        int b =Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());
        int count = 3;
        int answer = 0;
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int i = start; i < end; i++) {
                parking[i]++;
            }
        }

        for (int i : parking) {
            if(i == 1){
                answer += a * i;
            }
            if (i == 2) {
                answer += b * i;
            }
            if (i == 3) {
                answer += c * i;
            }
        }

        System.out.println(answer);
    }
}
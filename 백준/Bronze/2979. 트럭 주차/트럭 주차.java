import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int priceSize = 3;
        int[] price = new int[priceSize];
        for (int i = 0; i < priceSize; i++) {
            //br은 스트링이므로
            price[i] = Integer.parseInt(st.nextToken());
        }

        //입력으로 주어지는 시간은 1과 100사이 이다.
        int[] time = new int[101];
        // 시간은 이상 ~ 미만
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <  end; j++) {
                time[j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i < 101; i++) {
            if(time[i] == 1) answer += price[0];
            else if (time[i] == 2) answer += price[1]*2;
            else if (time[i] == 3) answer += price[2]*3;
        }

        System.out.println(answer);
    }
}
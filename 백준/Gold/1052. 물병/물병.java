import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b == 0){ System.out.println(-1);}
        else{
            int ans = 0;
            while (true){
                if(Integer.bitCount(a) <= b){ //탈출조건 물이찬 병의수가 조건보다 작거나 같다
                    break;
                }
                a++;
                ans++;
            }
            System.out.println(ans);
        }
    }
}

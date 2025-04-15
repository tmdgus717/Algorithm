import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            int del = s.indexOf(" ");
            int a = Integer.parseInt(s.substring(0, del));
            int b = Integer.parseInt(s.substring(del + 1));
            System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,a+b);
        }
    }
}

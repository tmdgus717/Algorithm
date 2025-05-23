import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            int del = s.indexOf(" ");
            int sum =
                Integer.parseInt(s.substring(0, del)) + Integer.parseInt(s.substring(del + 1));
            sb.append("Case #").append(i).append(": ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

}

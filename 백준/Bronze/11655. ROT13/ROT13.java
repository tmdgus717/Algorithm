import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//11655
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                int tmp = (char) (c + 13);
                if(tmp > 90) tmp -= 26;
                c = (char)tmp;
            }
            if (c >= 97 && c <= 122) {
                int tmp = (char) (c + 13);
                if(tmp > 122) tmp -= 26;
                c = (char)tmp;
            }

            sb.append(c);
        }
        System.out.println(sb);
    }
}

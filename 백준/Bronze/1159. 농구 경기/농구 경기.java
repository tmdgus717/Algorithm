
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        int num = Integer.parseInt(br.readLine());
        while (num-- > 0){
            String s = br.readLine();
            char c = s.charAt(0);
            alpha[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(alpha[i] >= 5) sb.append((char)(i+'a'));
        }

        if (sb.length() != 0) {
            System.out.println(sb);
        }
        else {
            System.out.println("PREDAJA");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        int[] answer = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            answer[c-'a']++;
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}

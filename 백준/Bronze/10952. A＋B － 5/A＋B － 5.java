import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String s = br.readLine();
            int delIndex = s.indexOf(" ");
            int a = Integer.parseInt(s.substring(0, delIndex));
            int b = Integer.parseInt(s.substring(delIndex + 1));
            if(a == 0) break;
            bw.write(String.valueOf(a + b));
            bw.newLine();

        }
        br.close();
        bw.flush();
        bw.close();

    }
}

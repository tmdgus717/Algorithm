import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int del = s.indexOf(" ");
        int n = Integer.parseInt(s.substring(0, del));
        int m = Integer.parseInt(s.substring(del + 1));
        int[] arr = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int t = 0; t < m; t++) {
            String line = br.readLine();
            del = line.indexOf(" ");
            int i = Integer.parseInt(line.substring(0, del));
            int j = Integer.parseInt(line.substring(del + 1));
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

}

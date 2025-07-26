import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] splits = s.split(" ");
        int n = Integer.parseInt(splits[0]);
        int m = Integer.parseInt(splits[1]);
        String[] pokName = new String[n + 1];
        HashMap<String, String> pokIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String pok = br.readLine();
            pokName[i + 1] = pok;
            pokIndex.put(pok, String.valueOf(i + 1));
        }

        for (int i = 0; i < m; i++) {
            String index = br.readLine();
            if ('0' <= index.charAt(0) && index.charAt(0) <= '9') {
                System.out.println(pokName[Integer.parseInt(index)]);
            }else {
                System.out.println(pokIndex.get(index));
            }
        }

    }
}

import java.io.*;
public class Main {//10808
    static int[] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (char c : s.toCharArray()) {
           int index = c - 'a';
           alpha[index]++;
        }//배열 값 채우기

        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}

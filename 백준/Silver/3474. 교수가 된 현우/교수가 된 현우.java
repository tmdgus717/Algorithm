import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int t = 0; t < n; t++) {
            int number = sc.nextInt();
            int count = 0;
            for (int i = 5; i <= number; i *= 5) {
                count += number / i;
            }
            System.out.println(count);
        }
    }
}

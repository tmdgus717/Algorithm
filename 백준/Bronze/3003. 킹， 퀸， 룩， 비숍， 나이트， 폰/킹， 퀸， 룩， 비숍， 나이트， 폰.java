import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        for (int i = 0; i < 6; i++) {
            int token = Integer.parseInt(st.nextToken());

            if (i == 0 || i == 1) {
                System.out.print(1 - token);
            } else if (i == 2 || i == 3 || i == 4) {
                System.out.print(2 - token);
            }else {
                System.out.println(8 - token);
            }
            System.out.print(" ");
        }
    }
}

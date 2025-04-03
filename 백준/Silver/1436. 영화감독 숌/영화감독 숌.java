import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int i = 666;
        while (true) {
            if (String.valueOf(i).contains("666")) {
                count++;
            }
            if (count == n) {
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}

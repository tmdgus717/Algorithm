import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        for (int i = 10; i <= 1000; i*=10) {
            int remainder = b % i;
            b -= remainder;
            int tmp = a * remainder;
            System.out.println(tmp / (i/10));
            sum += tmp;
        }
        System.out.println(sum);
    }

}

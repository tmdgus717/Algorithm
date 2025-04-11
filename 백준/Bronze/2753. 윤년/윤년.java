import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        //윤년이면 1 아니면 0
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
}

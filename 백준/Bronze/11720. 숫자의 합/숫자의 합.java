import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - 48;
        }
        System.out.println(sum);
    }

}

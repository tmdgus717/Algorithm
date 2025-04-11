import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int totalMin = B + C;
        int min = totalMin % 60;
        int addTime = totalMin / 60;
        int time = A + addTime;
        time %= 24;
        System.out.printf("%d %d", time, min);
    }

}

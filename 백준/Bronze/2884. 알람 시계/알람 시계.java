import java.util.*;
public class Main {

    public static void main(String[] args) {
        //45분 일찍 알람 설정하기
        // (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(b < 45){
            if (a == 0) {
                a = 24;
            }
            a--;
            b = b + 60;
        }
        b = b - 45;
        System.out.printf("%d %d", a, b);
    }

}

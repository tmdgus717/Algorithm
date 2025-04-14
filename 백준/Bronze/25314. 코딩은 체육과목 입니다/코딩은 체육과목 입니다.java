import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt(); //4~100
        int cnt = n / 4;

        if (n % 4 != 0) {
            cnt ++;
        }

        //==출력==//
        for (int i = 0; i < cnt; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }

}

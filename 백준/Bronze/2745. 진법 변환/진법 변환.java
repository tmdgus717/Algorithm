import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int del = s.indexOf(" ");
        String n = s.substring(0, del);
        String b = s.substring(del + 1);
        int answer = 0;
        int pointer = 1;

        //10진법 기준으로 먼저 구현

        //36진법수 n 을 10진법으로 출력
        for (int i = n.length() - 1; i >= 0; i--) { //끝부터 0번 인덱스까지
            char tmp = n.charAt(i);
            int number = 0;
            if (tmp >= '0' && tmp <= '9') {
                number = tmp - '0';
            }else {
                number = tmp - 'A' + 10;
            }
            answer += number * pointer;

            pointer *= Integer.parseInt(b);
        }

        System.out.println(answer);
    }
}

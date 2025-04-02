import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
//2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 각 자릿수가 모두 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {

            int num = scan.nextInt();
            int mod = 0;

            for(int i = 1;;i++){
                mod = (mod*10+1)%num;
                if(mod == 0) {
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}

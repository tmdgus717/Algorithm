import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {//1629 곱셈
    //mod 연산 개념을 사용한 풀이?
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 1;
        //시간초과 발생 b 가 문제!!
        //2^8 = 2^4 * 2^4
        System.out.println(pow(a, b, c));

    }

    public static long pow(int a, int b,int c) {
        if(b == 1) return a % c;

        long temp = pow(a, b / 2, c);
        if(b % 2 == 1){
            return temp * temp % c * a % c;
        }
        return temp * temp % c;
    }
}

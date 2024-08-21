import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//2828

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken()); //얘는 뭐지?
        int m = Integer.parseInt(st.nextToken()); //r에 대입
        int l = 1; //상태 초기화
        int r = m;

        int t = Integer.parseInt(bufferedReader.readLine()); //횟수
        int totalMove = 0; //결과값
        while (t-- > 0) {
            int position = Integer.parseInt(bufferedReader.readLine());
            //r보다 클때
            if(r<position){
                int move = position - r;
                totalMove += move;
                l += move;
                r += move;
            }
            //l보다 작을때
            if (l > position) {
                int move = l - position;
                totalMove += move;
                l -= move;
                r -= move;
            }
        }

        System.out.println(totalMove);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //번호 : 이름 쌍
        Map<Integer, String> map1 = new HashMap<>();
        //이름 : 번호 쌍
        Map<String, Integer> map2 = new HashMap<>();

        //1번부터 들어감
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            map1.put(i, tmp);
            map2.put(tmp, i);
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            //0~9
            //아스키 코드 : 48~57
            // 숫자로 시작하면 숫자이다
            // 앞부분이 이름이면 숫자 X
            if(tmp.charAt(0) >= 65){
                System.out.println(map2.get(tmp));
            }else{
                System.out.println(map1.get(Integer.parseInt(tmp)));
            }
        }
    }
}
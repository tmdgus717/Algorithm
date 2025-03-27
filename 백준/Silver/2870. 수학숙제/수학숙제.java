import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) { // 소문자가 아니면 실행
                    sb.append(c);
                }
                else  {
                    if (sb.length() > 0) {
                        list.add(deleteZero(sb));
                    }
                    sb = new StringBuilder();
                }
            }

            if (sb.length() > 0) {
                list.add(deleteZero(sb));
            }
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

         for (String num : list) {
            System.out.println(num);
        }
    }

    public static String deleteZero(StringBuilder stringBuilder) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (s.length() != 0 || c != '0') {//일단 값이 하나라도 들어가있다면 0도 넣는다
                s.append(c);
            }
        }
        if (s.length() == 0) {
            s.append("0");
        }
        return s.toString();
    }
}

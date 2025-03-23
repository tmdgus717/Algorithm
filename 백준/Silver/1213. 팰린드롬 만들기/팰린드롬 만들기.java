
import java.util.*;
public class Main {

    private static final String SORRY = "I'm Sorry Hansoo";
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        //배열로 저장
        int[] alpha = new int[26];
        //홀수가 몇개인지 카운팅

        String string = scanner.nextLine();
        for (char c : string.toCharArray()) {
            alpha[c - 65]++;
        }

        //뭔가 스택을 쓸것같은 느낌적인 느낌이 조금 드는데
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 65);
            //1개의 char 로 앞뒤로 붙이기 위함
            int stackCount = alpha[i] / 2;
            boolean isOdd = alpha[i] % 2 == 1;
            for (int count = 0; count < stackCount; count++) {
                characters.add(c); //캐릭터의 갯수 만큼 넣음
            }
            //홀수값들 저장
            if(isOdd){
                sb.append(c);
            }
        }//배열순회

        if (sb.length() >= 2) {
            System.out.println(SORRY);
        }else {
            while (!characters.empty()) {
                char tmp = characters.pop();
                sb.append(tmp);
                sb.insert(0, tmp);
            }
            System.out.println(sb);
        }

    }//main
}//K

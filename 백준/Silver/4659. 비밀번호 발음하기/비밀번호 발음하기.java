import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while (true){
            String s = br.readLine();
            boolean flag = true;
            boolean vowelFlag = false;
            int consonantCount = 0;
            int vowelCount = 0;
            Character prev = null;
            //while 종료조건
            if(s.equals("end")) break;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (vowels.contains(tmp)){//모음
                    vowelCount++;
                    consonantCount = 0;
                    vowelFlag = true;
                }else {//자음
                    consonantCount++;
                    vowelCount = 0;
                }

                if(vowelCount == 3 || consonantCount == 3){
                    flag = false;
                }

                //이전 값이 존재하고
                //이전 값과 현재값이 같고
                //tmp는 a도 아니고 e도 아니면 실행
                if(prev != null && prev == tmp && (tmp != 'o' && tmp != 'e')){
                    flag = false;
                }
                prev = tmp;
            }

            //출력
            if (flag && vowelFlag) {
                System.out.println("<"+s+"> is acceptable.");
            }else {
                System.out.println("<"+s+"> is not acceptable.");
            }
        }
    }

}

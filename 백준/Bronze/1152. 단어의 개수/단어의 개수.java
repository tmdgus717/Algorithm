import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //trim, strip 는 양쪽 공백을 지워주는 메서드 (SQL trim 과는 조금 다른듯?)
        //" " 이라면 빈 문자열 반환
        //배열의 길이는 배열.length
        //스트링의 길이는 스트링.length()
        //컬렉션의 길이는 컬렉션.size()
        s = s.strip();
        if (s.isEmpty()) { //빈문자열인지 체크해야한다 why? " ".strip() -> ""
            System.out.println(0);
            System.exit(0);
        }
        String[] split = s.split(" ");
        System.out.println(split.length);
    }

}

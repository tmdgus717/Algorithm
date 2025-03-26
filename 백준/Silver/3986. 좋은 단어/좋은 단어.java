import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); //'\n' 문자 읽기

        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            count += solve(s);
        }
        System.out.println(count);
    }

    private static int solve(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) { //스택이 비어있으면 값 추가
                stack.add(c);
                continue;
            }
            if (c == stack.peek()) { //제일 위 값이랑 현재 값이 같으면 stack 에서 제거
                stack.pop();
                continue;
            }
            stack.add(c);
        }

        if (stack.empty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}

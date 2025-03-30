import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            Stack<Character> chars = new Stack<>();
            boolean isVps = true;
            for (char c : s.toCharArray()) {
                if (chars.isEmpty()) {
                    chars.add(c);
                }else {
                    if (chars.peek() == '(') {
                        if (c == ')')
                            chars.pop();
                        else
                            chars.add(c);
                    } else {
                        chars.add(c);
                    }
                }
            }

            if (!chars.isEmpty()) {
                isVps = false;
            }

            if (isVps) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    } //main
}

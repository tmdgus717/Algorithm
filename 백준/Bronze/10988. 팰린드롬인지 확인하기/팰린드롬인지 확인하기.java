import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean flag = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                flag = false;
                break;
            }
        }
        if(flag == true) System.out.println(1);
        else System.out.println(0);
    }
}

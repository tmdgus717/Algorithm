import java.util.Scanner;

public class Main {

    /**
     * 아스키 코드
     * A 65
     * a 97
     * 0 48
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ascii = s.charAt(0);

        System.out.println(ascii);
    }

}

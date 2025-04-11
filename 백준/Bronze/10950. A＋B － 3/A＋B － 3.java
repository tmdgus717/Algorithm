import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }
    }

}

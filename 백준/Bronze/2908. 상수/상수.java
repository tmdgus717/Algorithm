import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int del = s.indexOf(" ");

        StringBuilder sb1 = new StringBuilder(s.substring(0,del)).reverse();
        StringBuilder sb2 = new StringBuilder(s.substring(del+1)).reverse();

        if (Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString())) {
            System.out.println(sb1);
        }else {
            System.out.println(sb2);
        }
    }
}

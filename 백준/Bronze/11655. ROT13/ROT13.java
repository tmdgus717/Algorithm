import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String answer = "";

        for (char c : s.toCharArray()) {
            if(c>='A' && c <= 'Z')  {
                c = (char) (c + 13);
                if(c > 'Z') c = (char)(c - 26);

            }
            else if(c >= 'a' && c<= 'z'){
                c = (char) (c + 13);
                if(c > 'z') c = (char)(c - 26);
            }
            System.out.print(c);
        }
    }
}
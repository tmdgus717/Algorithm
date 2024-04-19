import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            arr[tmp.charAt(0)-97]++;
        }

        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if(arr[i]>=5){
                System.out.print((char)(i+97));
                flag = true;
            }
        }

        if(flag == false) System.out.println("PREDAJA");
    }
}

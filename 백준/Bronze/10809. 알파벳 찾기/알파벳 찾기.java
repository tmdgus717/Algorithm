import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 97;
            if (arr[index] == -1) {
                arr[index] = i;
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

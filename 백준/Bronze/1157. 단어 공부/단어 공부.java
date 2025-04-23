import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = Character.toLowerCase(s.charAt(i)) - 97;
            arr[c]++;
        }

        int maxIndex = 0;
        int count = 1;
        for (int i = 1; i < 26; i++) {
            if (arr[i] > arr[maxIndex]){
                count = 1;
                maxIndex = i;
            }
            else if(arr[i] == arr[maxIndex]){
                count++;
            }
        }

        if (count == 1) {
            System.out.println((char)(maxIndex + 65));
        }else{
            System.out.println("?");
        }
    }

}

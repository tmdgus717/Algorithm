import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성하세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[200];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= n; i++) {

            arr[i] = arr[i - 1] + arr[i - 3];
        }
        System.out.println(arr[n]);
    }
}

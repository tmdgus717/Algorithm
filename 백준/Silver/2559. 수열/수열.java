import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //최소값 설정
        int max = -100 * 100000;

        //구간합 문제!!
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt() + arr[i-1]; //이전값과 현재값을 누적
        }
        for (int i = k; i < n + 1; i++) {
            int temp = arr[i] - arr[i - k];
            max = Math.max(max,temp);
        }

        System.out.println(max);
    }
}

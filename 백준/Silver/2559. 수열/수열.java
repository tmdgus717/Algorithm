import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        //n = 전체 날짜의 수, k = 합을 구하기 위한 연속적인 날짜의 수
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 배열 생성
        int[] arr = new int[n+1];
        //여기에 누적합으로 풀어야 할 것 같은 느낌이 들기는 하는데
        for (int i = 1; i <= n; i++) {

            int num = sc.nextInt();
            arr[i] = arr[i - 1] + num;
        }

        int max = 0;
        for (int i = k; i <= n; i++) {
            int tmp = arr[i] - arr[i - k];
            if (i == k) {// max 값이 0보다 작은 경우가 있을 수 있다!! (반례)
                max = tmp;
                continue;
            }
            if (tmp > max) max = tmp;
        }

        System.out.println(max);
    }
}
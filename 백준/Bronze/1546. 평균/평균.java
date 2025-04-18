import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[101];
        int max = Integer.MIN_VALUE;
        int count = 0;
        double totalValue = 0;

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[tmp]++;
            max = Math.max(max, tmp);
        }

        for (int i = 0; i <= 100; i++) {
            if (arr[i] != 0) {
                count += arr[i];
                //double로 캐스팅해서 계산해야 한다
                double tmp = (double) i / max * 100;
                totalValue += tmp * arr[i];
            }
        }

        System.out.println(totalValue / count);

    }

}

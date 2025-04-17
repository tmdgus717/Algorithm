import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100]; //100보다 작은 자연수
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 9; i++) {
            int value = sc.nextInt();
            arr[value] = i;
            max = Math.max(max, value);
        }
        System.out.printf("%d\n%d",max,arr[max]);
    }

}

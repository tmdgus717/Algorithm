import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;
        int front = 0;
        int rear = n - 1;
        while (front < rear) {
            if (arr[front] + arr[rear] == m){
                count++;
                front++;
                rear--;
            }
            else if (arr[front] + arr[rear] < m) {
                front++;
            }
            else if (arr[front] + arr[rear] > m) {
                rear--;
            }
        }

        System.out.println(count);
    }//main

}

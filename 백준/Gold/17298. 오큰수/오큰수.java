import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        Stack<Integer> stack = new Stack<>();//인덱스 저장
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && arr[stack.peek()] < tmp) {
                arr[stack.pop()] = tmp;
            }
            stack.push(i);
            arr[i] = tmp;
        }

        for (int index : stack) {
            arr[index] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

}

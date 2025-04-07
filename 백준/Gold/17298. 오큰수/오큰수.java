import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n]; // 값을 저장하기 위한 배열!!
        Stack<Integer> stack = new Stack<>();//index를 저장하기 위한 스택!!! 값을 저장하는 것이 아니다!!

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int index = 0; index < n; index++) {
            int current = arr[index];
            if (stack.isEmpty()) {
                stack.add(index);
                continue;
            }

            while (!stack.isEmpty() && arr[stack.peek()] < current) {
                int beforeIndex = stack.pop();
                arr[beforeIndex] = current;
            }
            stack.add(index);
        }

        //스택에 남아있는 영역 -1로 초기화
        for (int index : stack) {
            arr[index] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }//main

}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int T = sc.nextInt();
            int[] map = new int[20];
            for (int i = 0; i < 20; i++) {
                map[i] = sc.nextInt();
            }

            int[] sorted = new int[20];
            int answer = 0;

            for (int i = 0; i < 20; i++) {
                //1. 자신보다 큰 학생을 찾는다
                //1-1. 찾지 못한다면 배열 맨뒤에 넣는다
                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if(sorted[j] > map[i]){
                        flag = true;
                        //2. 뒤로 한칸씩 물린다
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            answer++;
                        }
                        //3. 앞에 값을 넣는다
                        sorted[j] = map[i];
                        break;
                    }
                }

                if (!flag) sorted[i] = map[i];
            }

            System.out.println(T + " " + answer);
        }
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //15000 : 15000! 이건 너무 값이 큰데...
        int m = sc.nextInt(); //10000000 -> 차라리 이걸가짖고 작업하는게 좋을 것 같은데
        List<Integer> items = new ArrayList<>(); //100000
        for (int i = 0; i < n; i++) {
            items.add(sc.nextInt());
        }

        if (m > 200000) {
            System.out.println(0);
            return;
        }

        Collections.sort(items); //인덱스로 삭제해야하는데 어떻게 해야할까..
        int count = 0;
        int flag = n - 1;
        //로직
        for (int i = 0; i < n; i++) {
            int first = items.get(i);
            for (int j = flag; j > i; j--) {
                if (first + items.get(j) == m) {
                    count++;
                    flag = j -1;
                }
            }
            if (i == flag) {
                break;
            }
        }

        System.out.println(count);

    }
}

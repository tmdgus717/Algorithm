import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성하세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m+1];
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= m; i++){
            if(i >= n && arr[i] == 0) primes.add(i);
            for(int j = i; j<=m; j += i){
                if(arr[j] == 0) arr[j]++;
                else continue;
            }
        }

        for(int i : primes){
            System.out.println(i);
        }
    }
}

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] dices = new int[7];
        dices[a]++;
        dices[b]++;
        dices[c]++;
        int max = 0;

        for (int i = 1; i <=6; i++) {
            if(dices[i]==3){
                System.out.println(10000 + (i * 1000));
                break;
            }
            if (dices[i] == 2) {
                System.out.println(1000 + (i * 100));
                break;
            }
            if (dices[i] != 0) {
                max = Math.max(max,i);
            }
            if (i == 6) {
                System.out.println(max * 100);
            }
        }
    }
}

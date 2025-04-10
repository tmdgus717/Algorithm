import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        //10의 12 까지 들어올 수 있다
        //int 형은 약 10의 9승, long 형은 10의 18승
        //더크면? BigInteger big = new BigInteger("1000000000000000000000000000000000000000000");
        System.out.println(
            Long.parseLong(split[0]) + Long.parseLong(split[1]) + Long.parseLong(split[2]));
    }

}

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = br.readLine();
            if (s == null) break;
            int num = Integer.parseInt(s);
            int answer = 1;
            int count = 1;

            while (true){
                if (answer % num == 0){
                    System.out.println(count);
                    break;
                }else {
                    answer = (answer * 10 + 1) % num;
                    count++;
                }
            }

        }//while(입력받은 횟수만큼)
    }//main

}

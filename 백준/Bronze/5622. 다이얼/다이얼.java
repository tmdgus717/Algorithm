import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        while (true) {
            int c = System.in.read();
            if (c == '\n') {
                break;
            }

            if (c < 68) answer += 3; //c
            else if (c < 71) answer += 4; //f
            else if (c < 74) answer += 5; //i
            else if(c < 77) answer += 6; //l
            else if(c < 80) answer += 7; //o
            else if(c < 84) answer += 8;
            else if(c< 87) answer += 9;
            else if(c < 91) answer += 10;
        }
        System.out.println(answer);
    }

}

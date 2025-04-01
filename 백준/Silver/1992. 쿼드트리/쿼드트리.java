import java.util.*;
import java.io.*;

public class Main{

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n은 언제나 2의 제곱수 2,4,8,16,32,64
        arr = new char[n][n];

        //입력받기
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        quadTree(0,0,n);

    }//main

    private static void quadTree(int y,int x,int n) {

        char tmp = arr[y][x];
        if (n == 1) {
            System.out.print(tmp); //재귀함수 종료조건
            return;
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp != arr[i+y][j+x]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            System.out.print(tmp);
        }
        else {
            System.out.print('(');
            quadTree(y, x, n / 2);
            quadTree(y, x + n / 2, n / 2);
            quadTree(y + n / 2, x, n/2);
            quadTree(y + n / 2, x + n / 2, n / 2);
            System.out.print(')');
        }

    }
}

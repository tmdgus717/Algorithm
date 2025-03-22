//package chapter01;

import java.io.*;
import java.util.*;
public class Main{

    private static String DA = "DA";
    private static String NE = "NE";

    public static void main(String[] args) throws Exception {
        List<String> answers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //횟수 n 입력받기
        int n = Integer.parseInt(br.readLine());

        //패턴
        String tmp = br.readLine();
        int asteriskIndex = tmp.indexOf('*');

        String front = tmp.substring(0, asteriskIndex);
        String back = tmp.substring(asteriskIndex + 1);

        for (int i = 0; i < n; i++) {

            String fileName = br.readLine();
            if (front.length() + back.length() > fileName.length()) {
                answers.add(NE);
                continue;
            }

            int fileNameLength = fileName.length();
            String fileFront = fileName.substring(0, front.length());
            String fileBack = fileName.substring(fileNameLength - back.length(), fileNameLength);
            //앞부분 비교
            if (front.equals(fileFront) && back.equals(fileBack)) {
                answers.add(DA);
            }else {
                answers.add(NE);
            }
        }//for

        for (String answer : answers) {
            System.out.println(answer);
        }
    }//main
}

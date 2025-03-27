import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int teamNumber = 0;
        int preTime  = 0;
        int flag = 0;
        int[] arr = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //team 정보
            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            String[] split = time.split(":");
            //분과 초로 변환
            int min = Integer.parseInt(split[0]);
            int sec = Integer.parseInt(split[1]);
            //시간정보
            int realTime = min * 60 + sec;

            //처음골을 넣으면
            if(teamNumber == 0){
                if(team == 1) flag--;
                if(team == 2) flag++;
                teamNumber = team;
                preTime = realTime;
                continue;
            }

            if(team == 1) flag--;
            if(team == 2) flag++;

            if(flag == 0){
                arr[teamNumber] += realTime - preTime;
                //동점으로 변경
                teamNumber = 0;
                preTime = realTime;
            }
        }

        int value = 48 * 60 - preTime;
        arr[teamNumber] += value;

        //출력
        for (int i = 1; i < 3; i++) {
            int time = arr[i];
            int m = time / 60;
            int s = time % 60;
            //20:00 형태로 변경
            String sm = String.valueOf(m);
            String ss = String.valueOf(s);
            if (sm.length() < 2) {
                sm = "0" + sm;
            }
            if (ss.length() < 2) {
                ss = "0" + ss;
            }
            System.out.println(sm+":"+ss);
        }
    } // main

}

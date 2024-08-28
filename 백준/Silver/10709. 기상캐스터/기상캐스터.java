import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {//10709
    static int[][] arr;
    static int[][] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        vis = new int[h][w];

        for (int i = 0; i < h; i++) {
            Arrays.fill(vis[i], -1);
        }

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                if (s.charAt(j) == 'c') {
                    arr[i][j] = 1;
                }
            }
        } //세팅

        for (int i = 0; i < h; i++) {
            int pre = 0;
            boolean flag = false;
            for (int j = 0; j < w; j++) {
                pre++;
                if(arr[i][j] == 1) {
                    vis[i][j] = 0;
                    pre=0;
                    flag = true;
                }
                else if(flag){//이전 구름이 있으면
                    vis[i][j] = pre;
                }
            }
        }//

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }//출력
    }//main
}

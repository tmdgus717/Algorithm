import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String ls = s.substring(0,s.indexOf("*"));
        String rs = s.substring(s.indexOf("*")+1);
        String yes = "DA";
        String no = "NE";
        for (int i = 0; i < n; i++) {

            String tmp = br.readLine();
            boolean flag = true;

            if (ls.length() + rs.length() > tmp.length()) {
                flag = false;
            }

            if(!tmp.startsWith(ls) || !tmp.endsWith(rs) ){
                flag = false;
            }
            //print
            if(flag) System.out.println(yes);
            else System.out.println(no);
        }//for
    }//main
}//Main
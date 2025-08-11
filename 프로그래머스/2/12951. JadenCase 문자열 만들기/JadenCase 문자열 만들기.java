import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String before = "";
        for(int i=0;i<s.length();i++){
            String tmp = String.valueOf(s.charAt(i));
            if(before.equals(" ") || i == 0){
                sb.append(tmp.toUpperCase());
            }else{
                sb.append(tmp.toLowerCase());
            }
            before = tmp;
        }
        answer = sb.toString();
        return answer;
    }
}
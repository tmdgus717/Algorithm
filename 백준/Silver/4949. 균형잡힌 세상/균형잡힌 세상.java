import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            //===필요한 변수 선언===//
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isBalance = true;
            //===종료조건===//
            if (s.equals(".")) {
                break;
            }

            //===logic===//
            for (Character c : s.toCharArray()) {
                if (c == '(' || c == '[') stack.add(c);
                if (c == ')') {
                    if(stack.isEmpty()){
                        isBalance = false;
                        break;
                    }
                    if(stack.peek() == '['){
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                }
                if (c == ']') {
                    if(stack.isEmpty()){
                        isBalance = false;
                        break;
                    }
                    if(stack.peek() == '('){
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                }
            }//for (Character c : s.toCharArray())

            //===stack 비어있지 않으면 균형이 아니다===//
            if (!stack.isEmpty()) {
                isBalance = false;
            }

            //===출력===//
            if(isBalance){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

}

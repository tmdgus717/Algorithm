import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        List<Integer> answers = new ArrayList<>();

        //테스트
        for (int i = 0; i < testCase; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            List<String> parts = new ArrayList<>();

            int n = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < n; j++) {
                String s = sc.nextLine();
                String[] split = s.split(" ");
                if(clothes.containsKey(split[1])){
                    int count = clothes.get(split[1]);
                    clothes.put(split[1], ++count);
                }
                else {
                    clothes.put(split[1], 1);
                    parts.add(split[1]);
                }
            }

            //경우의 수 수식적으로 풀자
            int count = 1;
            for (String s : parts) {
                count = count * (clothes.get(s) + 1);
            }
            answers.add(--count);
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}

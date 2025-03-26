import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>(); //순서를 보장해주는 hashmap
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (!linkedHashMap.containsKey(tmp)) {
                linkedHashMap.put(tmp, 1); //숫자, 횟수
                continue;
            }
            linkedHashMap.put(tmp, linkedHashMap.get(tmp)+1);
        }

        //정렬
        List<Integer> list = new ArrayList<>(linkedHashMap.keySet());
        list.sort((o1, o2) -> linkedHashMap.get(o2) - linkedHashMap.get(o1));

        for (Integer key : list) {
            for (int i = 0; i < linkedHashMap.get(key); i++) {
                System.out.print(key + " ");
            }
        }
    }

}

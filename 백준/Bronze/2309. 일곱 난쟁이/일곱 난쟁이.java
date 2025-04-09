import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static boolean isFound = false;
    //조합문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        //==조합으로 7난쟁이 찾기=//
        combi(0);
        //==sorting + print==//
        list.sort((a, b) -> a - b);
        for(Integer i : list){
            System.out.println(i);
        }
    }

    private static void combi(int idx) {
        if (isFound) return;

        if (list.size() == 7) {
            if (isOk()) {
                isFound = true;
                return;
            }
        }

        for (int i = idx; i < 9; i++) {
            list.add(arr[i]);
            combi(i+1);
            if (isFound) return;
            list.remove(list.size() - 1);
        }
    }

    private static boolean isOk() {
        int count = 0;
        for (Integer num : list) {
            count += num;
        }

        if (count == 100) return true;
        return false;
    }

}

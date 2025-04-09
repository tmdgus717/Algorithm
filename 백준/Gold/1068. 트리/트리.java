import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int root = 0;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //50이하 자연수
        String parentNodes = br.readLine();
        String[] parentNodeArray = parentNodes.split(" ");
        //==트리생성==//
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        //==트리그리기==//
        for (int i = 0; i < n; i++) {
            int parentNode = Integer.parseInt(parentNodeArray[i]);
            if(parentNode == -1){
                root = i;
                continue;//부모 노드가 없으면 무시
            }
            tree[parentNode].add(i);//0번 노드에 1번 2번 추가 , 1번 노드에 3번 4번 추가
        }

        int deletedNode = Integer.parseInt(br.readLine());

        if (deletedNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root, deletedNode);
        System.out.println(count);
    }

    public static void dfs(int nodeIndex, int deletedNode){
        boolean isLeaf = true;
        for(int there : tree[nodeIndex]){
            if (there == deletedNode) continue;
            isLeaf = false;
            dfs(there, deletedNode);
        }

        if (isLeaf) count++;
    }
}

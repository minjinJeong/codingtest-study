package doit.Chapter13_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 무료 강의에는 풀이가 없기 때문에 개인 풀이만 기재
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    static ArrayList<Integer>[] array;
    static int[][] parent;
    static int[] depth;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 초기화
        array = new ArrayList[N+1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[b].add(a);
            array[a].add(b);
        }

        // 깊이 배열과 부모 배열 초기화
        int max = 0;
        int temp = 1;
        while(temp < N+1) {
            temp <<= 1;
            max++;
        }

        depth = new int[N+1];
        parent = new int[N+1][max];

        // DFS로 초기화
        DFS(1, 1);
        for (int i = 1; i < max; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }

        // 구하기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b, max)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void DFS(int node, int depthLen) {
        
        // 현재 노드의 깊이 저장
        depth[node] = depthLen;

        // 연결된 노드 탐색
        for(int next : array[node]) {
            // 깊이는 1부터 시작하므로, 0이면 아직 탐색하지 않은 것이다.
            if(depth[next] == 0) {
                // 연결된 노드는 깊이가 1 깊어진다.
                DFS(next, depthLen+1);
                // 부모 노드는 현재 노드
                parent[next][0] = node;
            }
        }
    }

    private static int LCA(int a, int b, int max) {

        // 깊이가 깊은 것을 a 노드로 지정
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 부모 노드 탐색
        for (int i = max-1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a==b) {
            return a;
        }
        
        // 공통 부모 노드 탐색
        for (int i = max-1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                a = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
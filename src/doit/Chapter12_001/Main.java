package doit.Chapter12_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    static ArrayList<Integer>[] array;
    static int[] color;
    static boolean isBipartie;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        newGraph:
        for (int i = 0; i < K; i++) {

            isBipartie = true;

            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            color = new int[V+1];
            array = new ArrayList[V+1];
            for (int j = 0; j < array.length; j++) {
                array[j] = new ArrayList<Integer>();
            }

            // 초기화
            for (int j = 0; j < E; j++) {

                st = new StringTokenizer(br.readLine());

                int node_1 = Integer.parseInt(st.nextToken());
                int node_2 = Integer.parseInt(st.nextToken());

                array[node_1].add(node_2);
                array[node_2].add(node_1);
            }
            
            for (int j = 1; j < array.length; j++) {

                if (color[j] == 0) {
                    myDFS(j, 1);
                }

                if (!isBipartie) {
                    sb.append("NO\n");
                    continue newGraph;
                }
            }

            if (isBipartie) {
                sb.append("YES\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static int getNextColor(int nextColor) {
        return nextColor == 1 ? 2 : 1;
    }

    private static void myDFS(int node, int nextColor) {
        // 방문한 노드면 종료
        if (color[node] != 0) {
            return;
        }

        // 노드에 컬러 없으면 컬러 지정 (미방문 상태)
        color[node] = nextColor;

        // 인접 노드 돌면서 컬러 확인
        int c = getNextColor(nextColor);
        for (int n : array[node]) {
            // 삽입해야 할 컬러와 삽입되어 있는 컬러가 다르면 이분이 아님
            if (color[n] != 0 && color[n] != c) {
                isBipartie = false;
                return;
            }
            myDFS(n, c);
        }
    }

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    private static void answer() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            String[] s = br.readLine().split(" ");

            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;

            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<Integer>();
            }
            
            // 에지 데이터 저장하기
            for (int j = 0; j < E; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행 해야 함
            for (int j = 1; j <= V; j++) {
                if (IsEven) {
                    DFS(j);
                } else {
                    break;
                }
            }

            if (IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int i : A[start]) {
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            }
            else if (check[start] == check[i]) {
                IsEven = false;
            }
        }
    }
    
}
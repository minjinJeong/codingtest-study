package doit.Chapter9_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }
    
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];

        // 인접 리스트
        ArrayList<Integer>[] array = new ArrayList[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            // 방향 없는 그래프므로 양쪽 노드에 모두 연결
            array[node-1].add(next-1);
            array[next-1].add(node-1);
        }

        // 탐색 돌면서 연결 요소 카운팅
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            // 방문한 적 없으면 탐색 시작
            if(!visited[i]) {
                count++;
                myDFS(visited, array, i);
            }
        }

        System.out.println(count);
    }

    private static void myDFS(boolean[] visited, ArrayList<Integer>[] array, int i) {
        // 방문한 적 있으면 탐색 종료
        if (visited[i]) {
            return;
        }

        // 방문했으므로 표시
        visited[i] = true;

        // 인접 노드 탐색
        for (int node : array[i]) {
            myDFS(visited, array, node);
        }
    }
    
    static ArrayList<Integer>[] A;
    static boolean visited[];
    private static void answer() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        A = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    
}
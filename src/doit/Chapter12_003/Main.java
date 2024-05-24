package doit.Chapter12_003;

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

        int[] D = new int[N+1];
        ArrayList<Integer> array[] = new ArrayList[N+1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<Integer>();
        }

        // 인접 리스트 초기화
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a].add(b);
            D[b] = D[b]+1;
        }
        
        // 정렬
        ArrayList<Integer> sort = new ArrayList<Integer>();
        while(sort.size() < N) {
            for (int i=1; i<=N; i++) {
                int node = D[i];
                // 진입 차수가 0인 것 선택
                if (node == 0) {
                    // 선택한 노드 출력
                    sort.add(i);
                    D[i] = -1;
                    // 선택한 노드의 인접 리스트 개수 초기화
                    for(int n : array[i]) {
                        D[n] = D[n] - 1;
                    }
                    break;
                }
            }
        }

        for(int node : sort) {
            System.out.printf(node + " ");
        }
    }

    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            A.add(new ArrayList<>());
        }

        int indegree[] = new int[N+1];
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for(int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
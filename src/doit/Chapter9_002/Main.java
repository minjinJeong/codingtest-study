package doit.Chapter9_002;

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

        boolean[][] visit = new boolean[N][M];
        int[][] array = new int[N][M];

        // 배열 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] num = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(num[j]);
            }
        }

        // 상하좌우 좌표 배열
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};

        // 탐색하기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {

            // 큐에서 꺼내고 방문 체크
            int[] q = queue.poll();
            visit[q[0]][q[1]] = true;

            // 상하좌우 확인 (인접 노드 확인)
            for (int i = 0; i < 4; i++) {
                int x = q[0] + dx[i];
                int y = q[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (array[x][y] == 1 && !visit[x][y]) {
                        array[x][y] += array[q[0]][q[1]];
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        System.out.println(array[N-1][M-1]);
        
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    private static void answer() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >=0 && y>=0 && x<N && y<M) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
    
}
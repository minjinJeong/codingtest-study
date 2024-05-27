package doit.Chapter14_001;

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
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[N][K]);
    }

    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int D[][] = new int[N+1][N+1];

        // 초기화
        for (int i = 0; i <= N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        // 점화식으로 배열 완성하기
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[N][K]);
    }
}
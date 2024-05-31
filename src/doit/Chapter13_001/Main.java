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

    static int[][] array;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 초기화
        array = new int[N+1][N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[0][b] = a;
        }

        for (int i = 0; i < array.length; i++) {
            parent(2, i);
        }

        // 구하기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(array[a][b]);
        }
    }

    private static int parent(int K, int N) {
        if (K == 0) {
            return array[K][array[K][N]];
        }
        return array[K][N] = parent(K-1, N);
    }
}
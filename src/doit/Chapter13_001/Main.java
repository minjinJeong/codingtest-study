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

    static int[] unionFind;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 초기화
        int[][] array = new int[N+1][2];
        for (int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[i][0] = a;
            array[i][1] = b;
        }
    }
}
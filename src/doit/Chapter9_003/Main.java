package doit.Chapter9_003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        answer();
        // mySource();
    }
    
    // 미완
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[N][M];

        ArrayList<Integer>[] array = new ArrayList[N*M];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<Integer>();
        }

        // 인접 리스트 만들기

        // 탐색하기
    }
    
    private static void answer() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = A.length -1;

        while (start <= end) {
            int mid_index = (start + end) / 2;
            int mid_value = A[mid_index];

            if(mid_value > target) {
                end = mid_index-1;
            }
            else if (mid_value < target) {
                start = mid_index+1;
            }
            else {
                find = true;
            }
        }
    }
}
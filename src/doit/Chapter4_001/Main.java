package doit.Chapter4_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        answer();
        // mySource();
    }

    private static void mySource() {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] sum = new int[N+1];

        for(int i=1; i<=N; i++) {
            int num = sc.nextInt();
            sum[i] = sum[i-1] + num;
        }

        for (int j = 0; j < M; j++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(sum[end] - sum[start-1]);
        }

        sc.close();
    }
    
    private static void answer() throws IOException {
        
        // 입력 값이 많기 때문에 BufferedReader 사용
        BufferedReader bufferedReader = 
            new BufferedReader((new InputStreamReader(System.in)));

        // 한 줄로 들어오면 int로 받기 힘들어서 StringTokenizer 사용
        StringTokenizer stringTokenizer =
            new StringTokenizer(bufferedReader.readLine());
        
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[suNo + 1];

        stringTokenizer =
            new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());

            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[j] - S[i-1]);
        }
    }
}
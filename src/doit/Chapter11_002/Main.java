package doit.Chapter11_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        System.out.println(M +" 의 서로소는 " + Euler(M));

        int N = Integer.parseInt(st.nextToken());
        Euler(M, N);
    }
    
    private static void Euler(int M, int N) {

        int[] A = new int[N+1];
        int[] res = new int[N+1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = i;
            res[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if(res[i] == i) { // 소수일 경우
                for (int j = i; j <= N; j=j+i) {
                    res[j] = res[j] - res[j] / i;
                }
            }
        }

        // 출력
        for (int i = M; i <= N; i++) {
            System.out.println(res[i]);
        }
    }
    
    private static int Euler(int N) {
        
        int res = N;
        for(int i=2; i <= Math.sqrt(N); i++){
            if(N % i == 0) {
                res = res - res/i;
                while(N%i == 0) {
                    N /= i;
                }
            }
        }
        if(N > 1) {
            res = res - res/N;
        }

        return res;
    }
}
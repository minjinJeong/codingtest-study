package doit.Chapter15_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    // 결과 오류
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N+1];

        if (N < 3) {
            System.out.println(N);
            return ;
        }

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i < D.length; i++) {
            // 여기서 %10007 해줘야 통과된다.
            D[i] = D[i-1] + D[i-2];
        }

        System.out.println(D[N]%10007);
    }

    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        System.out.println(D[N]);
    }
}
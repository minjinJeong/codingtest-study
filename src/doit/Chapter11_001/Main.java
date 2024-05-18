package doit.Chapter11_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        answer();
        // mySource();
    }

    // 시간 초과
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] array = new int[N-M+1];
        int index = 0;
        for (int i = M; i <= N; i++) {
            array[index++] = i;
        }

        int i = 2;
        index = 0;
        while (i > 0 && i <= N) {
            if (array[index] == i) {
                System.out.println(array[index++]);

                while (index < array.length-1 && array[index] == -1) {
                    index++;
                }
            }

            for (int j = index; j < array.length; j++) {
                // 소수가 아니면 체크
                if (array[j] != -1 && array[j]%i == 0) {
                    array[j] = -1;
                }
            }

            i = i < M ? i+1 : array[index];
        }
    }

    private static void answer() throws IOException {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];

        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) continue;
            for (int j = i+i; j <= N; j=j+i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
    
}
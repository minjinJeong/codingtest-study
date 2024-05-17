package doit.Chapter10_001;

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

        Integer[] array = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array, (o1, o2) -> {
            return o2 - o1;
        });

        int won = K;
        int count = 0;
        for (int coin : array) {
            if (coin == won) {
                count += 1;
                break;
            }
            else if (coin < won) {
                int num = won / coin;
                won = won - num*coin;                
                count += num;
            }
        }

        System.out.println(count);
    }

    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if (A[i] <= K) {
                count += (K/A[i]);
                K = K % A[i];
            }
 
        }

        System.out.println(count);
    }
    
}
package doit.Chapter8_001;

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

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i]);   
        }
    }
    
    private static void answer() throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 버블 정렬을 구현하는 영역
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
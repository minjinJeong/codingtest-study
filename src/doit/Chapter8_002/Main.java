package doit.Chapter8_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        answer();
        // mySource();
    }
    
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        int N = input.length;
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < array.length; i++) {
            int maxIndex = -1;
            int max = -1;
            for (int j = i; j < array.length; j++) {
                if(maxIndex < 0 || array[j] > max) {
                    max = array[j];
                    maxIndex = j;
                }
            }
            
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);
        }
    }
    
    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int A[] = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택정렬
        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i+1; j < str.length(); j++) {
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            if(A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
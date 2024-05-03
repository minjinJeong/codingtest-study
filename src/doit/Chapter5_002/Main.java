package doit.Chapter5_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // answer();
        mySource();
    }
    
    private static void mySource() {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        list.sort((a, b) -> a-b);

        int start_index = 0, end_index = 1;
        int sum = 0, count = 0;

        while (start_index < N-1) {

            sum = list.get(start_index) + list.get(end_index);
            
            if(sum == M) {
                count++;
                start_index++;
                end_index = start_index + 1;
            }
            else if (sum > M) {
                start_index++;
                end_index = start_index + 1;
            }
            else {
                end_index++;
            }

            if(end_index > N-1) {
                start_index++;
                end_index = start_index + 1;
            }
        }

        System.out.println(count);

        sc.close();
    }
    
    private static void answer() throws NumberFormatException, IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[N];
        StringTokenizer stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < j) {
            if (A[i] + A[j] < M) i++;
            else if (A[i] + A[j] > M) j--;
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
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
    
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());

            boolean isFind = false;
            int start = 0;
            int end = array.length-1;
            while (start <= end) {
                int index = (start + end) / 2;
                if (number < array[index]) {
                    end = index-1;
                } else if (number > array[index]) {
                    start = index+1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
    
    private static void answer() throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
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

            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
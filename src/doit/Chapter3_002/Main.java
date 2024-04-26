package doit.Chapter3_002;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // answer();
        mySource();
    }

    private static void mySource() {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        ArrayList<Integer> scoreList = new ArrayList<>();
        double max = 0;
        
        for(int i=0; i<N; i++) {
            int num = sc.nextInt();
            if (num > max) {
                max = num;
            }
            scoreList.add(num);
        }

        double sum = 0;
        for(int i=0; i<scoreList.size(); i++) {
            sum += (scoreList.get(i)/max*100.0);
        }
        
        System.out.println(sum/scoreList.size());

        sc.close();
    }
    
    private static void answer() {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // int A[] = new int[N];

        // for(int i=0; i<N; i++) {
        //     A[i] = sc.nextInt();
        // }

        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            // if(A[i]>max) max = A[i];
            // sum = sum + A[i];
            int temp = sc.nextInt();
            if(temp>max) max=temp;
            sum = sum + temp;
        }

        System.out.println(sum*100.0/max/N);
        sc.close();
    }
}
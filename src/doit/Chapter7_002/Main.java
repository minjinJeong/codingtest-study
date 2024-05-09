package doit.Chapter7_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // answer();
        mySource();
    }
    
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (count != N-1) {

            queue.poll();
            count++;

            if (count != N-1) {
                queue.offer(queue.poll());
            }
        }

        System.out.println(queue.poll());
    }
    
    private static void answer() {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }

        System.out.println(myQueue.poll());
    }
}
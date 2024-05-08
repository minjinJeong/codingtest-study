package doit.Chapter7_001;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // answer();
        mySource();
    }
    
    private static void mySource() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int stackNum = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            
            int num = sc.nextInt();
            if (num >= stackNum) {
                while (num >= stackNum) {
                    stack.push(stackNum++);
                    sb.append("+\n");   
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.pop() < num) {
                    System.out.println("NO");
                    return;
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        sc.close();

        System.out.println(sb.toString());
    }
    
    private static void answer() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i=0; i<A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su>=num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if(result) System.out.println(bf.toString());
    }
}
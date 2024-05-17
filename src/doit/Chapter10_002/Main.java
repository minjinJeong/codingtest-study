package doit.Chapter10_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }
    
    // ERROR
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        String seq = br.readLine();

        // 우선 순위: + -> -
        Stack<Integer> stack = new Stack<>();

        // 값 받으면서 더하기 연산 먼저 수행
        int number = 0;
        boolean isPlus = false;
        for (int i = 0; i < seq.length(); i++) {
            char s = seq.charAt(i);

            if (s == '+' || s == '-') {

                if (isPlus) {
                    number = stack.pop() + number;
                    isPlus = false;
                }
                if (s == '+') {
                    isPlus = true;
                }
                stack.push(number);
                number = 0;

            }  else {
                number = number*10 + (s-'0');
            }
        }
        if (isPlus) {
            number = stack.pop() + number;
            isPlus = false;
        }
        stack.push(number);

        // 빼기 연산
        int result = stack.pop();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                result = result - stack.pop();
            }
            result = -result;
        }

        System.out.println(result);
    }

    static int answer = 0;
    private static void answer() throws IOException {
        Scanner sc = new Scanner(System.in);

        String example = sc.nextLine();
        String[] str = example.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i==0) answer = answer + temp;
            else answer = answer - temp;
        }

        System.out.println(answer);
    }

    private static int mySum(String a) {
        int sum = 0;
        String[] temp = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
    
}
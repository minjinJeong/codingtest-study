package doit.Chapter6_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // answer();
        mySource();
    }
    
    private static void mySource() throws NumberFormatException, IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());

        int S = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());

        String[] str = stringTokenizer.nextToken().split("");

        stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());
        
        int len = 4;
        String[] DNA = {"A", "C", "G", "T"};
        int[] limit = {
            Integer.parseInt(stringTokenizer.nextToken()),
            Integer.parseInt(stringTokenizer.nextToken()),
            Integer.parseInt(stringTokenizer.nextToken()),
            Integer.parseInt(stringTokenizer.nextToken())
        };

        int[] current = new int[len];
        int start=0, end=P;

        // 0부터 P까지 돌면서 current 배열 완성하기
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < len; j++) {
                if (str[i] == DNA[j]) current[j]++;
            }
        }

        // 0부터 1씩 증가시켜가면서 current배열값이랑 limit 배열 값 비교하기
        boolean isOK = false;
        int count = 0;
        while (end < S) {
            for (int i = 0; i < len; i++) {
                if (current[i] < limit[i]) {
                    isOK = false;
                    return;
                }
            }

            if(isOK) {
                count++;
            }

            end++;
            for (int i = 0; i < len; i++) {
                if (str[start] == DNA[i]) {
                    current[i]--;
                }
                if (str[end] == DNA[i]) {
                    current[i]++;
                }
            }
            start++;
        }

        System.out.println(count);
    }
    
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    private static void answer() throws NumberFormatException, IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());

        int S = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        int Result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        char A[] = new char[S];
        checkSecret = 0;

        A = bufferedReader.readLine().toCharArray();

        stringTokenizer = 
            new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if(checkSecret == 4) Result++;
       
        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++;
        }

        System.out.println(Result);
        bufferedReader.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
            default:
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
            default:
                break;
        }
    }
}
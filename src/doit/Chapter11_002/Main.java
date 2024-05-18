package doit.Chapter11_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        long result = Euler(N);
        System.out.println(result);
    }
    
    private static long Euler(Long N) {
        
        long res = N;

        // 2부터 N의 제곱근까지 반복
        for(long i=2; i <= Math.sqrt(i); i++){
            if(N%i == 0){
                res = res - res/i;
                while(N%i == 0) {
                    N /= i;
                }
            }
        }

        if(N>1) {
            res = res - res/N;
        }
        
        return res;
    }
}
package doit.Chapter11_003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = gcd(N, M);
        System.out.println(result);

        result = lcm(N, M);
        System.out.println(result);
    }
    
    private static int gcd(int N, int M) throws IOException {
        int res = N % M;
        if (res == 0) return M;
        return gcd(M, res);
    }
    
    private static int lcm(int N, int M) throws IOException {
        return (N*M) / gcd(N, M);
    }
    
}
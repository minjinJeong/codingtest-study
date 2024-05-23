package doit.Chapter12_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    static int[] array;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[N+1];

        // 초기화: 대표 노드는 자기 자신
        for (int i = 0; i <= N; i++) {
            array[i] = i;
        }

        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operator == 0) {

                int rep_a = myFind(a);
                int rep_b = myFind(b);

                if (rep_a < rep_b) {
                    array[rep_b] = rep_a;
                } else {
                    array[rep_a] = rep_b;
                }

            } else {

                if (myFind(array[a]) == myFind(array[b])) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static int myFind(int num) {
        if (array[num] == num) {
            return num;
        }

        int rep = myFind(array[num]);
        array[num] = rep;
        return rep;
    }

    static int parent[];
    private static void answer() throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N+1];

        // 초기화
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        // 질의 계산
        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(question == 0) { // union
                union(a,b);
            } else {
                boolean result = checkSame(a, b);
                if (result) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        // 대표노드를 찾아서 연결하기
        a = find(a);
        b = find(b);
        if(a != b) {
            // 두 개 연결
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if(a == parent[a]) return a;
        else {
            // value를 index로 바꿔서 또 찾아보기
            return parent[a] = find(parent[a]);
        }
    }
    
    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return true;
        return false;
    }
}
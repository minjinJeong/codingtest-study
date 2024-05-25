package doit.Chapter12_004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 무료 강의에는 풀이가 없기 때문에 개인 풀이만 기재
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    static int[] unionFind;
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 초기화
        int[][] array = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            array[i][0] = a;
            array[i][1] = b;
            array[i][2] = c;
        }

        unionFind = new int[V+1];
        for (int i = 1; i < unionFind.length; i++) {
            unionFind[i] = i;
        }

        // 오름차순 정렬
        Arrays.sort(array, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        // 에지 만들기
        int edge = 0;
        int result = 0; // 가중치
        while (edge != V-1) {
            for (int[] in : array) {
                // 대표 노드 찾기
                int rep_a = myFind(in[0]);
                int rep_b = myFind(in[1]);

                if (rep_a != rep_b) {
                    // 대표 노드끼리 연결
                    myUnion(rep_a, rep_b);
                    result += in[2];
                    edge++;
                }
            }
        }

        System.out.println(result);
    }

    private static void myUnion(int a, int b) {
        if (a < b) {
            unionFind[b] = a;
        }
        else {
            unionFind[a] = b;
        }
    }

    private static int myFind(int num) {

        if (num == unionFind[num]) {
            return num;
        }

        return unionFind[num] = myFind(unionFind[num]);
    }
}
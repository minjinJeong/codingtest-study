package doit.Chapter12_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        // answer();
        mySource();
    }

    private static class Node {
        int E;
        int V;

        public Node(int E, int V) {
            this.E = E;
            this.V = V;
        }
    }

    // 인접 그래프 미완
    private static void mySource() throws IOException {

        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] array = new ArrayList[V+1];

            for (int j = 0; j < E; j++) {

                st = new StringTokenizer(br.readLine());

                int node_1 = Integer.parseInt(st.nextToken());
                int node_2 = Integer.parseInt(st.nextToken());

                if (array[node_1].isEmpty() && array[node_2].isEmpty()) {
                    array[node_1].add(new Node(node_2, 0));
                    array[node_2].add(new Node(node_1, 0));
                }
            }
        }

    }

    private static void answer() throws IOException {

        
    }
    
}
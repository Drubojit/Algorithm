package primsdemo;

import java.util.Scanner;

public class PrimsDemo {

    int minimumValue(int value[], boolean flag[], int vertices) {

        int minimum = Integer.MAX_VALUE, minimumindex = -1;

        for (int v = 0; v < vertices; v++) {
            if (flag[v] == false && value[v] < minimum) {
                minimum = value[v];
                minimumindex = v;
            }
        }
        return minimumindex;
    }

    void print(int parent[], int vertices, int graph[][]) {
        System.out.println("Edge \t\tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " --- " + i + "-----------"
                    + graph[i][parent[i]]);
        }
    }

    void primsAlgorithm(int graph[][], int vertices) {
        int parent[] = new int[vertices];

        int value[] = new int[vertices];

        boolean flag[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            value[i] = Integer.MAX_VALUE;
            flag[i] = false;
        }

        value[0] = 0;
        parent[0] = -1;

        for (int k = 0; k < vertices - 1; k++) {
            int u = minimumValue(value, flag, vertices);

            flag[u] = true;

            for (int v = 0; v < vertices; v++) {

                if (graph[u][v] != 0 && flag[v] == false
                        && graph[u][v] < value[v]) {
                    parent[v] = u;
                    value[v] = graph[u][v];
                }
            }
        }

        print(parent, vertices, graph);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices;
        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        PrimsDemo obj = new PrimsDemo();

        int graph[][] = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            System.out.println("Enter " + (i + 1) + "th element with adjacent element weight ");
            for (int j = 0; j < vertices; j++) {

                int weight = input.nextInt();
                graph[i][j] = weight;
            }
        }

        obj.primsAlgorithm(graph, vertices);
    }

}

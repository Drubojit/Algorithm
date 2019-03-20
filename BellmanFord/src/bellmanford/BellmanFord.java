package bellmanford;

import java.util.Scanner;

public class BellmanFord {

    class Edge {

        int source, destination, weight;

        Edge() {
            source = destination = weight = 0;
        }
    };
    int V, E;
    Edge edge[];

    
    


    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    void bellfordalgorithm(BellmanFord graph, int source) {
       int V = graph.V;
       int E = graph.E;
        int distance[] = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
            }
           
        }
        print(distance, V);

    }

    void print(int dist[], int V) {
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices, edges;
        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        System.out.println("Enter number of edges: ");
        edges = input.nextInt();

        BellmanFord graph = new BellmanFord(vertices, edges);
        for (int i = 0; i < edges; i++) {
            int s, d, w;
            s = input.nextInt();
            d = input.nextInt();
            w = input.nextInt();
            graph.edge[i].source = s;
            graph.edge[i].destination = d;
            graph.edge[i].weight = w;
        }
        graph.bellfordalgorithm(graph, 0);
    }

}

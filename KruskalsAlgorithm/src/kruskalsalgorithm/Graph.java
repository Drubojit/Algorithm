package kruskalsalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Graph {

    class Edge implements Comparable<Edge> {

        int src, dest, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    class subset {

        int parent, rank;
    };
    int V, E;
    Edge edge[];

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    int find(subset subsets[], int i) {

        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void krushkal() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i) {
            result[i] = new Edge();
        }

        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new subset();
        }

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < V - 1) {

            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {

                result[e++] = next_edge;
                Union(subsets, x, y);
            }

        }

        System.out.println("Following are the edges in "
                + "the constructed MST");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- "
                    + result[i].dest + " == " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices, edge;
        System.out.println("Enter number of vertices:");
        vertices = input.nextInt();
        System.out.println("Enter number of Edges:");
        edge = input.nextInt();
        Graph obj = new Graph(vertices, edge);
        for (int i = 0; i < 5; i++) {
            int n1, n2, n3;
            System.out.println("Enter source:");
            n1 = input.nextInt();
            obj.edge[i].src = n1;

            System.out.println("Enter Destination:");
            n2 = input.nextInt();
            obj.edge[i].dest = n2;

            System.out.println("Enter Weight:");
            n3 = input.nextInt();
            obj.edge[i].weight = n3;

        }

        obj.krushkal();

    }
}

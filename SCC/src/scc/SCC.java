package scc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SCC {

    private int V;
    private LinkedList<Integer> adj[];

    SCC(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void transposetraversal(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!visited[n]) {
                transposetraversal(n, visited);
            }
        }
    }

    SCC Transposegraph() {
        SCC g = new SCC(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                g.adj[i.next()].add(v);
            }
        }
        return g;
    }

    void traversal(int v, boolean flag[], Stack s) {
        flag[v] = true;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!flag[n]) {
                traversal(n,flag, s);
            }
        }

        s.push(new Integer(v));
    }

    void print() {
        Stack s = new Stack();

        boolean flag[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            flag[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (flag[i] == false) {
                traversal(i,flag,s);
            }
        }

        SCC gr = Transposegraph();

        for (int i = 0; i < V; i++) {
            flag[i] = false;
        }

        while (s.empty() == false) {

            int v = (int) s.pop();

            if (flag[v] == false) {
                gr.transposetraversal(v,flag);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices, edges;

        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        System.out.println("Enter number of edges: ");
        edges = input.nextInt();
        SCC obj = new SCC(vertices);
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter connection between edges: ");
            int n1, n2;
            n1 = input.nextInt();
            n2 = input.nextInt();
            obj.addEdge(n1, n2);
        }

        System.out.println("Connected Components");
              
        obj.print();
    }

}

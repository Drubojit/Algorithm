package dfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {

    private int V;
    private LinkedList<Integer> adj[];

    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addedge(int v, int c) {
        adj[v].add(c);
    }

    void traversal(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                traversal(n, visited);
            }
        }
    }

    void dfs(int v) {
        boolean visited[] = new boolean[V];
        traversal(v, visited);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices, edges, node;
        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        System.out.println("Enter number of edges: ");
        edges = input.nextInt();
        DFS obj = new DFS(vertices);
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the connection between vertices: ");
            int n1, n2;
            n1 = input.nextInt();
            n2 = input.nextInt();
            obj.addedge(n1, n2);
        }
        System.out.println("Enter starting node: ");
        node = input.nextInt();
        System.out.println("Path: ");
        obj.dfs(node);
    }

}

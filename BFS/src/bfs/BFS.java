package bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];

    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addedge(int v, int c) {
        adj[v].add(c);

    }

    void bfsmethod(int startingnode) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[startingnode] = true;
        queue.add(startingnode);
        while (queue.size() != 0) {
            startingnode = queue.poll();
            System.out.println(startingnode + " ");
            Iterator<Integer> i = adj[startingnode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices, edges, node;
        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        System.out.println("Enter number of edeges: ");
        edges = input.nextInt();
        BFS obj = new BFS(vertices);
        for (int i = 0; i < edges; i++) {
            int n1, n2;
            System.out.println("Enter connection between vertices: ");
            n1 = input.nextInt();
            n2 = input.nextInt();
            obj.addedge(n1, n2);
        }
        System.out.println("Enter starting node: ");
        node = input.nextInt();
        System.out.println(" path: ");
        obj.bfsmethod(node);
    }

}

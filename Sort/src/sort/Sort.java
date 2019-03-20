
package sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Sort {
private int V;
private LinkedList<Integer> adj[];
Sort(int v)
{
    V=v;
    adj=new LinkedList[v];
    for(int i=0;i<v;i++)
    {
        adj[i]=new LinkedList<Integer>();
    }
}
void addedge(int v,int w)
{
    adj[v].add(w);
}
void traversal(int v, boolean visited[], 
                             Stack s) 
    { 
      
        visited[v] = true; 
        Integer i; 
  
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            if (!visited[i]) 
                traversal(i, visited, s); 
        } 
  
       
        s.push(new Integer(v)); 
    } 
  
    void topologicalSort() 
    { 
        Stack s = new Stack(); 
  
       
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) {
            visited[i] = false; 
        }
  
    
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                traversal(i, visited, s);
            }
  
        }
        while (s.empty()==false) {
            System.out.print(s.pop() + " ");
        }
        
    } 
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
        int vertices, edges, node;
        System.out.println("Enter number of vertices: ");
        vertices = input.nextInt();
        System.out.println("Enter number of edeges: ");
        edges = input.nextInt();
         Sort obj = new Sort(vertices);
        for (int i = 0; i < edges; i++) {
            int n1, n2;
            System.out.println("Enter connection between vertices: ");
            n1 = input.nextInt();
            n2 = input.nextInt();
            obj.addedge(n1, n2);
        }
       System.out.println("Topological Sort: ");
       obj.topologicalSort();
    }
    
}

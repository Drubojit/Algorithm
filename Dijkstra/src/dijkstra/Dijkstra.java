
package dijkstra;

import java.util.Scanner;


public class Dijkstra {
public static int minimumvalue(int distance[],int vertices,boolean flag[])
{
   int min=Integer.MAX_VALUE,minindex=-1;
   for(int i=0;i<vertices;i++)
   {
       if(flag[i]==false && distance[i]<min)
       {
           min=distance[i];
           minindex=i;
       }
   }
   return minindex;
}



public static void printpath(int distance[],int vertices)
{
    System.out.println("Distance from source");
    for(int i=0;i<vertices;i++)
    {
        System.out.println(i+"----------"+distance[i]);
    }
}



public static  void dijkstra(int graph[][],int source,int vertices)
{
    boolean flag[]=new boolean [vertices];
    int distance[]=new int[vertices];
    for(int i=0;i<vertices;i++)
    {
        distance[i]=Integer.MAX_VALUE;
        flag[i]=false;
    }
    
    distance[source]=0;
    for(int k=0;k<vertices-1;k++)
    {
       int u=minimumvalue(distance,vertices,flag);
       flag[u]=true;
       for(int v=0;v<vertices;v++)
       {
           if(!flag[v] && graph[u][v]!=0 && distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][v]<distance[v])
           {
               
               distance[v]=distance[u]+graph[u][v];
           }
       }
    }
    
    printpath(distance,vertices);
}

    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       int vertices=input.nextInt();
       int graph[][]=new int[vertices][vertices];
       for(int i=0;i<vertices;i++)
       {
           for(int j=0;j<vertices;j++)
           {
               int weight=input.nextInt();
               graph[i][j]=weight;
           }
       }
       /*int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; */
       
       dijkstra(graph,0,vertices);
       
    }
    
}

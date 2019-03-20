
#include<bits/stdc++.h>

using namespace std;

int parent[100];
struct edges{
    int u;
    int v;
    int w;
};
vector<edges> vec;

bool compare(edges lhs, edges rhs) {return lhs.w < rhs.w; }


int find_parent(int r)
{
    if(parent[r] != r)
        return parent[r] = find_parent(parent[r]);
    else
        return r;
}


int main()
{
   // freopen("inputKruskal.txt", "r", stdin);
    int node,edge;

    //cout << "Enter Node Number: ";
    cin >> node;
    //cout << "Enter Edge Number: ";
    cin >> edge;
    int source,destination,weight;
    for(int i=0;i<edge;i++)
     {
        int s,d,w;
        cin>>s>>d>>w;
         edges[i].u=s;
         edges[i].v=d;
         edges[i].w=w;
     }



    for(int i=0; i<node; i++)
    {
        parent[i] = i;
    }
    //cout << "Enter edge to edge with weight" << endl;

    for(int i=0; i<edge; i++)
    {
        edges temp;
        cin >> temp.u >> temp.v >> temp.w;
        vec.push_back(temp);
    }

    sort(vec.begin(), vec.end(),compare);

    int sz = vec.size();

    int cost = 0;

    cout << "Edges of the MST are: \n\n" << endl;
    for(int i=0; i<edge; i++)
    {
        int x = find_parent(vec[i].u);
        int y = find_parent(vec[i].v);
        if(x != y)
        {
            parent[y] = x;
            cost = cost + vec[i].w;
            cout << "Edge: " <<  vec[i].u << " --- " << vec[i].v << " With Cost: " << vec[i].w << endl;
        }
    }

    cout << "\nCost of MST is : " << cost << endl;
    return 0;
}

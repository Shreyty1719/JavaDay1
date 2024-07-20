import java.util.*;
public class day3{
    public static class edge{
        int src;
        int dest;
        public edge(int s,int d){
            this.src=s;
            this.dest=d ;
        }
    }
    public static void insert(ArrayList<edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }




graph[0].add(new edge(0,1));

graph[0].add(new edge(0,2));
graph[0].add(new edge(0,3));

graph[1].add(new edge(1,0));
graph[1].add(new edge(1,2));

graph[2].add(new edge(2,0));
graph[2].add(new edge(2,1));


graph[3].add(new edge(3,0));
graph[3].add(new edge(3,4));

graph[4].add(new edge(4,3));

    }
    public static void dfs(ArrayList<edge> graph[],int curr,int par,int dis[],int low[],int time,boolean vis[],boolean ap[]){
vis[curr]=true;
dis[curr]=low[curr]=++time;
int children=0;
for(int i=0;i<graph[curr].size();i++){
    edge e=graph[curr].get(i);
    int neigh=e.dest;
    if(par==neigh){
        continue;
    }
    else if(!vis[neigh]){
        dfs(graph,neigh,curr,dis,low,time,vis,ap);
        low[curr]=Math.min(low[curr],low[neigh]);
        if(dis[curr]<=low[neigh] && par!=-1){
            
            if(!ap[curr]){
                ap[curr]=true;
            System.out.println("AP"+"----->"+curr);
        }
        }
        children++;
    }
    else{
        low[curr]=Math.min(low[curr],dis[neigh]);
    }
}
if(par==-1 && children>1 && ap[curr]==false){
       System.out.println("AP"+"------>"+curr);
}

    }
    public static void tarjan(ArrayList<edge> graph[],int V){
        int dis[]=new int[V];
        int low[]=new int[V];
        int time=0;
    boolean vis[]=new boolean[V];
    boolean ap[]=new boolean[V];

for(int i=0;i<V;i++){
    vis[i]=false;
}
for(int i=0;i<V;i++){
    if(!vis[i]){
        dfs(graph,i,-1,dis,low,time,vis,ap);
    }
}

    }
    public static void main(String args[]){
        ArrayList<edge> graph[]=new ArrayList[5];
      
        insert(graph);
        tarjan(graph,5);
    }
}
import java.util.*;
public class day2 {
     static class edge{
        int src;
        int dest;
        public edge(int s,int d){
            this.src=s;
            this.dest=d ;
        }
    }
    public static void insert(ArrayList<edge> graph[]){
        //Arrays.fill(graph,new ArrayList<edge>());
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<edge>();
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
        graph[3].add(new edge(3,5));

       graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));

        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));

    }
    public static void dfs(ArrayList<edge> graph[],int curr,int par,int dis[],int low[],Boolean vis[],int time){
        vis[curr]=true;
        dis[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par){
                continue;
            }
            else if(!vis[neigh]){
            
                dfs(graph,neigh,curr,dis,low,vis,time);
                low[curr]=Math.min(low[curr],low[neigh]);
                //System.out.println(curr+"------->"+neigh);
               if(dis[curr]<low[neigh]){
                System.out.println(curr+"------->"+neigh);
               }
            }
            else{
                low[curr]=Math.min(low[curr],dis[neigh]);
            }
        }  
    }
    public static void tarjan(ArrayList<edge> graph[],int V){
        // int par[]=new int[V];
        int dis[]=new int[V];
        int low[]=new int[V];
        Boolean vis[]=new Boolean[V];
        Arrays.fill(vis,false);
        int time=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dis,low,vis,time);
            }
        }
    }
   public static void main(String args[]){
    int V=6;
    ArrayList<edge> graph[]=new ArrayList[V];
    insert(graph);
    tarjan(graph,V);
   } 
}

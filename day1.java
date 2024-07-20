import java.util.*;
public class day1{
    public static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void insert(ArrayList<edge> graph[]){
graph[0].add(new edge(0,2));
graph[0].add(new edge(0,3));
graph[1].add(new edge(1,0));
graph[2].add(new edge(2,1));
graph[3].add(new edge(3,4));
    }
    public static void topsort(ArrayList<edge> graph[],Boolean vis[],int curr,Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!vis[e.dest]){
            topsort(graph,vis,e.dest,s);
        }
        }
        s.push(curr);
    }

public static void dfs(int curr,ArrayList<edge> newgraph[],Boolean vis[]){
    vis[curr]=true;
System.out.print(curr+"");
    for(int i=0;i<newgraph[curr].size();i++){
      edge e=newgraph[curr].get(i);
      if(!vis[e.dest]){
      dfs(e.dest,newgraph,vis);}
    }
}
    
    public static void kosa(ArrayList<edge> graph[]){
        Stack<Integer> s=new Stack<>();
        Boolean vis[]=new Boolean[graph.length];
   Arrays.fill(vis,false);

   for(int i=0;i<graph.length;i++){
    if(!vis[i]){
  topsort(graph,vis,i,s);
    }
   }
  
   ArrayList<edge> newgraph[]=new ArrayList[graph.length];
   for(int i=0;i<graph.length;i++){
    vis[i]=false;
    newgraph[i]=new ArrayList<edge>();
   }
   for(int i=0;i<graph.length;i++){
    for(int j=0;j<graph[i].size();j++){
edge e=graph[i].get(j);
newgraph[e.dest].add(new edge(e.dest,e.src));
    }
   }
   
   while(!s.isEmpty()){
    int curr=s.pop();
//   System.out.println(curr);
     if(!vis[curr]){
        // System.out.println(curr);
        System.out.print("SCC"+"->");

        dfs(curr,newgraph,vis);
        System.out.println();
     }

   }
}
    
    public static void main(String agrs[]){
        ArrayList<edge> graph[]=new ArrayList[5];
for(int i=0;i<graph.length;i++){
    graph[i]=new ArrayList<edge>();
}
insert(graph);
kosa(graph);
    }
}


import java.util.*;
public class practce{
    public static class edge{
        int src;
        int dest;
        public edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void insert(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
          
        }
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));

        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,1));
        graph[2].add(new edge(2,3));

        graph[3].add(new edge(3,2));
        graph[3].add(new edge(3,4));

        graph[4].add(new edge(4,3));
    }
    public static int find(int a,int rank[],int par[]){
        if(par[a]==a){
            return a;
        }
        return par[a]=find(par[a],rank,par);
    }
    public static Boolean union(ArrayList<edge> graph[],int a,int b,int rank[],int par[]){
        int par1=find(a,rank,par);
        int par2=find(b,rank,par);
        if(par1==par2 && par[par1]!=a){
            return true;
        }
        else if(rank[par1]==rank[par2]){
            par[par2]=par1;
            rank[par1]++;

        }
        else if(rank[par1]>rank[par2]){
            par[par2]=par1;
        }
        else{
            par[par1]=par2;
        }
        return false;

    }
    public static void detect(ArrayList<edge> graph[]){

    }
    public static void main(String args[]){
        ArrayList<edge> graph[]=new ArrayList[5];
        insert(graph);
        detect(graph);
    }
}
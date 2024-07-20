public class maxseg {
    public static void construct(int arr[],int tree[],int i,int si,int e){
        if(si==e){
            tree[i]=arr[si];
            return ;
        }
        int mid=(si+e)/2;
        construct(arr,tree,2*i+1,si,mid);
        construct(arr,tree,2*i+2,mid+1,e);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    public static void updateutil(int tree[],int i,int si,int sj,int ind,int newval){
        if(ind>sj || ind<si){
            return ;
        }
    if(si==sj){
        tree[i]=newval;
    }
        if(si!=sj){
            tree[i]=Math.max(tree[i],newval);
            int mid=(si+sj)/2;
            updateutil(tree,2*i+1,si,mid,ind,newval);
            updateutil(tree,2*i+2,mid+1,sj,ind,newval);
        }
    }
    public static void update(int arr[],int tree[],int ind,int newval){
         arr[ind]=newval;
    updateutil(tree,0,0,8,ind,newval);
    }
    public static int max(int arr[],int tree[],int i,int si,int sj,int qi,int qj){
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE;
        }
        if(si>=qi && sj<=qj){
            return tree[i];
        }
        else{
        int mid=(si+sj)/2;
        int left=max(arr,tree,2*i+1,si,mid,qi,qj);
        int right=max(arr,tree,2*i+2,mid+1,sj,qi,qj);
        return Math.max(left,right);}
    }
    public static void main(String args[]){
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        int tree[]=new int[4*n];
        construct(arr,tree,0,0,n-1);
    System.out.println(max(arr,tree,0,0,8,2,5));
    update(arr,tree,2,-2);
    System.out.println(max(arr,tree,0,0,8,2,5));
    System.out.println(tree[8]);
    }
}

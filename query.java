public class query {
    public static void construct(int arr[],int tree[],int i,int s,int e){
        if(s==e){
            tree[i]=arr[s];
            return ;
        }
        int mid=(s+e)/2;
        construct(arr,tree,2*i+1,s,mid);
        construct(arr,tree,2*i+2,mid+1,e);
        tree[i]=tree[2*i+1]+tree[2*i+2];

    }
    public static int sum(int arr[],int tree[],int i,int si,int sj,int qi,int qj){
        if(qj>=si || sj<=qi){
            return 0;
        }
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        int mid=(si+sj)/2;
        int l=sum(arr,tree,2*i+1,si,mid,qi,qj);
        int r=sum(arr,tree,2*i+2,mid+1,sj,qi,qj);
        return l+r;
    }
    public static int get(int arr[],int tree[],int qi,int qj){
        return sum(arr,tree,0,0,7,qi,qj);
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        int tree[]=new int[n*4];
        construct(arr,tree,0,0,7);
        System.out.println(get(arr,tree,2,5));

    }
}

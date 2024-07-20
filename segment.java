public class segment {
    public static void construct(int arr[],int tree[],int i,int s,int e){
        if(s==e){

            tree[i]=arr[s];
            // return arr[s];
            return;
        }

        int mid=(s+e)/2;
        construct(arr,tree,2*i+1,s,mid);
        construct(arr,tree,2*i+2,mid+1,e);
        tree[i]=tree[2*i+1]+tree[2*i+2];
        // return tree[i];
    }
    public static int sum(int arr[],int tree[],int i,int si,int sj,int qi,int qj){
        if(qj<=si || sj<=qi){
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
    public static void updateutil(int tree[],int i,int si,int sj,int ind,int diff){
        if(ind <si || ind>sj){
            return ;
        }
        tree[i]=tree[i]+diff;
        if(si!=sj){
            int mid=(si+sj)/2;
            updateutil(tree,2*i+1,si,mid,ind,diff);
            updateutil(tree,2*i+2,mid+1,sj,ind,diff);
        }

    }
    public static void update(int arr[],int tree[],int ind,int newval){
        int diff=newval-arr[ind];
       arr[ind]=newval;
        updateutil(tree,0,0,7,ind,diff);
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        int tree[]=new int[4*n];
        construct(arr,tree,0,0,n-1);
        System.out.println(get(arr,tree,2,5));
        update(arr,tree,2,2);
        System.out.println(get(arr,tree,2,5));

    }
}

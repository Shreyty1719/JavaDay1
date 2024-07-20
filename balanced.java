public class balanced {
    public static void main(String args[]){
        int n=4;
        int arr[]=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
          arr[i]=arr[i]+arr[j]*arr[i-j-1];
            }
        }
        System.out.println(arr[n]);
    }
}

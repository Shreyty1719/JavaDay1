public class tribonacci {
    public static void main(String args[]){
        int n=20;
        int arr[]=new int [n];
        arr[0]=0;
        arr[1]=0;
        arr[2]=1;
        for(int i=3;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(arr[5]);
    }
}

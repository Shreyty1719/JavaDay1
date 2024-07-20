public class mcmtab {
    public static void main(String args[]){
        int arr[]={1,2,3,4,3};
        int n=arr.length;
    int dp[][]=new int[n][n];
    for(int len=2;len<=n-1;len++){
        for(int i=1;i<=n-len;i++){
   int j=len+i-1;
   dp[i][j]=Integer.MAX_VALUE;
   for(int k=i;k<=j-1;k++){
    int c1=dp[i][k];
    int c2=dp[k+1][j];
    int c3=arr[i-1]*arr[k]*arr[j];
    dp[i][j]=Math.min(dp[i][j],c1+c2+c3);
   }
        }
    }
    System.out.println(dp[1][n-1]);
    for(int i=1;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }
    }
}

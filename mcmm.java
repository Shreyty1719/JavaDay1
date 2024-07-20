import java.util.*;
public class mcmm {
    public static int mcm(int dp[][],int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int c1=mcm(dp,arr,i,k);
            int c2=mcm(dp,arr,k+1,j);
            int c3=c1+c2+arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,c3);
        }
        return dp[i][j]=ans;
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,3};
        int n=arr.length;;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(mcm(dp,arr,1,4));
    }
}

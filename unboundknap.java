import java.util.*;
public class unboundknap {
    public static int knap(int dp[][],int n,int m,int wt[],int val[]){
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static void main(String args[]){
int val[]={15,14,10,45,30};
int arr[]={2,5,1,3,4};
int w=7;
int n=arr.length+1;
int m=w+1;
int dp[][]=new int[n][m];
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        if(i*j==0){
            dp[i][j]=0;
        }
    }
}
System.out.println(knap(dp,n,m,arr,val));
    }
}

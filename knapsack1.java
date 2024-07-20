import java.util.*;
public class knapsack1 {
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int knap(int val[],int wt[],int dp[][]){
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1]<=j){
                    int inc=val[i-1]+dp[i-1][j-wt[i-1]];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String args[]){
        int n=5;
        int w=7;
        int dp[][]=new int[n+1][w+1];
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};

        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i*j==0){
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(knap(val,wt,dp));
        System.out.println();
        print(dp);
    }
}

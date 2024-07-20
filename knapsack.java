import java.util.*;
public class knapsack {
    public static int knap(int val[],int wt[],int w,int n,int dp[][]){
        if(w==0 || n==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        if(wt[n-1]<=w){
            int ans1=val[n-1]+knap(val,wt,w-wt[n-1],n-1,dp);
            int ans2=knap(val,wt,w,n-1,dp);
            return dp[n][w]=Math.max(ans1,ans2);
        }
        else{
            return dp[n][w]=knap(val,wt,w,n-1,dp);
        }
        
    }
    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int dp[][]=new int[6][8];
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knap(val,wt,7,5,dp));

    }
}

import java.util.*;
public class coin {
    public static int change(int dp[][],int n,int m,int coin[]){
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(coin[i-1]<=j){
   dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }

        }
        return dp[n-1][m-1];
    }
    public static void main(String args[]){
        int coin[]={2,5,3,6};
        int sum=10;
        int dp[][]=new int[5][11];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        System.out.println(change(dp,5,11,coin));
    }
}

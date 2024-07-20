import java.util.*;
public class catlan {
    public static int cat(int n){
        if(n==0 || n==1){
            return 1;
        }
        
            int ans=0;
            for(int i=0;i<=n-1;i++){
  ans+=cat(i)*cat(n-i-1);
            }
        return ans;
    }
    public static int catm(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catm(i,dp)*catm(n-i-1,dp);
        }
return dp[n]=ans;
    }
    public static void main(String args[]){
        int n=15;
        // System.out.println(cat(30));
        int  dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catm(n,dp));
    }
}

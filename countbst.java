import java.util.*;
public class countbst {
    public static int count(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
   for(int j=0;j<=i-1;j++){
    dp[i]=dp[i]+dp[j]*dp[i-j-1];
   }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=3;
        System.out.println(count(n));
    }
}

import java.util.*;
public class catt {
    public static void main(String args[]){
        int n=3;
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        dp[1]=1;
        int ans=0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                dp[i]=dp[i]+dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
}

import java.util.*;
public class lcsmemo {
    public static int common(String s1,String s2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=common(s1,s2,n-1,m-1,dp)+1;
        }
        else{
           int ans1=common(s1,s2,n-1,m,dp);
           int ans2=common(s1,s2,n,m-1,dp);
           return dp[n][m]=Math.max(ans1,ans2);
        }
      
    }
    public static void main(String args[]){
        String s1="abcde";
        String s2="ace";
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(common(s1,s2,n,m,dp));
    }
}

import java.util.*;
public class targetdp {
    public static boolean find(int val[],boolean dp[][],int tar,int n,int m){
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int v=val[i-1];
                if(v<=j){
                    
                 dp[i][j]=dp[i-1][j-v] || dp[i-1][j];

                }
               else{
                dp[i][j]=dp[i-1][j];
               }
                
            }
        }
       return dp[n-1][m-1];
    }
    public static void printt(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int val[]={4,2,7,1,3};
        int tar=20;
        boolean dp[][]=new boolean[val.length+1][tar+1];
       for(int i=0;i<=val.length;i++){
       dp[i][0]=true;
       }
// for(int j=1;j<dp[0].length;j++){
//     dp[0][j]=false;
// }
       System.out.println(find(val,dp,tar,6,11));
       printt(dp);
    }
}

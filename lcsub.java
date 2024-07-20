public class lcsub {
    public static void main(String args[]){
        String s1="ABCDE";
        String s2="ABGCE";
        int n=s1.length();
        int m=s2.length();
        int ans=0;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
       for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
       }
    }
}

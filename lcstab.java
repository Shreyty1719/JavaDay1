public class lcstab {
    public static void main(String args[]){
        String s1="abcdge";
        String s2="abedg";
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        int n=s1.length();
        int m=s2.length();
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                  int  ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}

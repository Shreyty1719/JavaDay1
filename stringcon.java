public class stringcon {
    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length(); 
        int dp[][]=new int[n+1][m+1];
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
        return dp[n][m];
    }
    public static int con(String s1,String s2){
        int l=lcs(s1,s2);
        System.out.println(l);
        return (s1.length()-l)+(s2.length()-l);
    }
    public static void main(String args[]){
        String s1="abcdefg";
        String s2="aceg";
        System.out.println(con(s1,s2));
    }
}

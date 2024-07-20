public class wild {
    public static Boolean match(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        Boolean dp[][]=new Boolean[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=false;
            }
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
    if(i==0 && j==0){
        dp[i][j]=true;
    }
    else if(i!=0 && j==0){
        dp[i][j]=false;
    }
    else if(i==0 && j!=0){
        if(s2.charAt(j-1)=='*'){
            dp[i][j]=dp[i][j-1];
        }
    }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int  j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)|| s2.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(s2.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]){
        String s1="abc";
        String s2="**d";
        System.out.println(match(s1,s2));
    }
}

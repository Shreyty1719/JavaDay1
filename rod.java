import java.util.*;
public class rod{
    public static int cut(int length[],int val[],int torod){
        int dp[][]=new int[length.length+1][torod+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String args[]){
        int length[]={1,2,3,4,5,6,7,8};
        int val[]={1,5,8,9,10,17,17,20};
        int torod=8;
        System.out.println(cut(length,val,torod));
    }
}
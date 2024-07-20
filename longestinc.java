import java.util.*;
public class longestinc{
    public static int lip(int arr[][],int i,int j,int dp[][]){
if(i>=arr.length || i<0 || j<0 || j>=arr[0].length){
    return 0;
}
if(dp[i][j]!=-1){
    return dp[i][j];
}
int curr=1;
if(i+1< arr.length && arr[i][j]<arr[i+1][j]){
    curr=Math.max(curr,1+lip(arr,i+1,j,dp));
}
if(j+1<arr[0].length && arr[i][j]<arr[i][j+1]){
    curr=Math.max(curr,1+lip(arr,i,j+1,dp));
}
dp[i][j]=curr;
return curr;

    }
    public static void main(String args[]){
        int arr[][]={{1,2,3,4},{2,2,3,4},{3,2,3,4},{4,5,6,7}};
        int dp[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                res=Math.max(res,lip(arr,i,j,dp));
            }
        }
System.out.println(res);
    }
}

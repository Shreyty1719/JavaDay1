import java.util.HashSet;
import java.util.*;
public class lis {
    public static int lcs(int arr[],int arr1[]){
        int n=arr.length;
        int m=arr1.length;
        int dp[][]=new int[arr.length+1][arr1.length+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr1[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int liss(int arr[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int i=0;
        int arr1[]=new int[set.size()];
        for(Integer num:set){
            arr1[i]=num;
            i++;
        }
        Arrays.sort(arr1);
        return lcs(arr,arr1);
    }
    public static void main(String args[]){
        int arr[]={50,3,10,7,40,80};
        System.out.println(liss(arr));
    }
}

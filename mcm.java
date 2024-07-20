import java.util.*;
public class mcm{
    public static int count(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int c1=count(arr,i,k);
            int c2=count(arr,k+1,j);
            int c3=c1+c2+arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,c3);
        }
        return ans;
    }
public static void main(String args[]){
    int arr[]={1,2,3,4,3};
    int n=arr.length;
    System.out.println(count(arr,1,n-1));
}
}
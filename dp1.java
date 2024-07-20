import java.util.*;
public class dp1{
    public static void main(String args[]){
        int arr[]=new int[7];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=6;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(arr[6]);
    }
}
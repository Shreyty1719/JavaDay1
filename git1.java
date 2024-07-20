import java.util.*;

public class git1 {
    public static int binarySearch(int arr[],int l,int h,int k){
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==k){
              
                return mid;
            }
            else if(arr[mid]<k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int arr[]=new int[5];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(binarySearch(arr,0,4,5));
    }
}

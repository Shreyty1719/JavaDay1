import java.util.*;
public class targetsum {
    public static boolean target(int num[],int tar,int i){
        if(tar==0){
    return true;
}

if(i>=num.length || tar<0){
    return false;
}

    return target(num,tar-num[i],i+1) || target(num,tar,i+1);
 
    }
    public static void main(String args[]){
        int num[]={4,2,3};
        int tar=10;
        ArrayList<Integer> list=new ArrayList<>();
    System.out.println(target(num,tar,0));
    // target(num,tar,list,0);
    }
}

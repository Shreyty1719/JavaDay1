import java.util.*;
public class lcs {
    public static int commonse(String s,String e,int n,int m){
if(n==0 || m==0){
    return 0;
}
if(s.charAt(n-1)==e.charAt(m-1)){
return commonse(s,e,n-1,m-1)+1;
}
else{
    int ans1=commonse(s,e,n-1,m);
    int ans2=commonse(s,e,n,m-1);
    return Math.max(ans1,ans2);
}
    }
    public static void main(String args[]){
        String s1="abcde";
        String s2="ace";
        System.out.println(commonse(s1,s2,s1.length(),s2.length()));
    }
}

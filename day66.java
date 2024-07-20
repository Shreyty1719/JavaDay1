import java.util.*;
class Solution {
    public int maxHeight(int[][] cuboids) {
        int n=cuboids.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
            Arrays.sort(cuboids[i]);
        }
   Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });
   dp[0]=cuboids[n-1][2];
 for(int i=n-2;i>=0;i--){
   int max=cuboids[i][2];
   for(int j=i+1;j<n;j++){
    if(cuboids[i][0]<cuboids[j][0] && cuboids[i][1]<cuboids[j][1] && cuboids[i][2]<cuboids[j][2]){
        max=Math.max(max,cuboids[i][2]+cuboids[j][2]);
    }
   }

   dp[n-i-1]=max;
 }
     int res=Integer.MIN_VALUE;
     for(int i=0;i<n;i++){
        res=Math.max(res,dp[i]);
     }
return res;
    }
}
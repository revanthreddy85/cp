package Algorithms;

public class Ceil {

    int ceil(int n,int []a){
        int l=0,r=a.length-1,m,ans=a.length;
        while (l<=r){
            m=(l+r)/2;
            if(a[m]>=n){
                ans=m;
                r=m-1;
            }else
                l=m+1;
        }
        return ans;
    }

}

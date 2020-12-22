package Algorithms;

public class Pow_mod {
    int mod=(int)1e9+7;

    long pow(long x,long y)
    {
        long l=1;
        while(y>0)
        {
            if((y&1)==1)
                l*=x;
            l%=mod;
            y>>=1;
            x*=x;
            x%=mod;
        }
        return l;
    }
}

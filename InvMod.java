package FastIO;

public class InvMod {
    int mod=(int)1e9+7,maxn=(int)3e5+5;
    long []fact;
    long []invfact;

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

    long ncr(int n,int r)
    {
        if(r>n)
            return 0;
        long num=fact[n]*invfact[r];
        num%=mod;
        num*=invfact[n-r];
        num%=mod;
        return num;
    }

    void precompute(){
        fact=new long[maxn];
        invfact=new long[maxn];
        fact[0]=1;
        for(int i=1;i<maxn;i++)
            fact[i]=fact[i-1]*i%mod;
        invfact[maxn-1]=pow(fact[maxn-1],mod-2);
        for(int i=maxn-2;i>=0;i--)
            invfact[i]=invfact[i+1]*(i+1)%mod;
    }
}

package FastIO;

public class Sieve {
    int maxn=1000005;

    void sieve_(){
        int []sieve=new int[maxn];
        for(int i=1;i*i<maxn;i++){
            if(sieve[i]==0){
                for(int j=i*i;j<maxn;j+=i)
                    sieve[j]=i;
            }
        }
    }

    void spf_(){
        int []spf=new int[maxn];
        for(int i=1;i<maxn;i++)
            spf[i]=i;
        for(int i=1;i*i<maxn;i++){
            if(spf[i]==i){
                for(int j=i*i;j<maxn;j+=i){
                    if(spf[j]==j)
                        spf[j]=i;
                }
            }
        }
    }
}

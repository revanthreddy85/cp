package FastIO;

public class FenTree {

    long []bit;
    int n;

    public FenTree(int n){
        this.n=n;
        bit=new long[n];
    }

    public long query(int ind){
        long ans=0;
//        ind+=offset;
        while(ind>0){
            ans+=bit[ind];
            ind -= ind&-ind;
        }
        return ans;
    }

    public void update(int ind,long val){
//        ind+=offset;
        while(ind<bit.length){
            bit[ind]+=val;
            ind += ind&-ind;
        }
    }

}

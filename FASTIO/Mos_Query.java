package FastIO;

public class Mos_Query implements Comparable <Mos_Query> {

    public int id,l,r,lc;
    public long ord;
//    void calcOrder() {
//        this.ord = gilbertOrder(l, r, 21, 0);
//    }

    public int compareTo(Mos_Query q) {
//        if (BL[l] != BL[q.l])
//            return Integer.compare(BL[l],BL[q.l]);
//        return (BL[l]&1)>1?Integer.compare(r,q.r):Integer.compare(q.r,r);
        return Long.compare(ord,q.ord);
    }

    long gilbertOrder(int x, int y, int pow, int rotate) {
        if (pow == 0) {
            return 0;
        }
        int hpow = 1 << (pow-1);
        int seg = (x < hpow) ? (
                (y < hpow) ? 0 : 3
        ) : (
                (y < hpow) ? 1 : 2
        );
        seg = (seg + rotate) & 3;
        int []rotateDelta= {3, 0, 0, 1};
        int nx = x & (x ^ hpow), ny = y & (y ^ hpow);
        int nrot = (rotate + rotateDelta[seg]) & 3;
        long subSquareSize = 1L << (2*pow - 2);
        long ans = seg * subSquareSize;
        long add = gilbertOrder(nx, ny, pow-1, nrot);
        ans += (seg == 1 || seg == 2) ? add : (subSquareSize - add - 1);
        return ans;
    }

//    r[1] = 1; for (int i=2; i<n; ++i) r[i] = (m — (m/i) * r[m%i] % m) % m;

    void compute(){
//        int curL = queries[0].l, curR = queries[0].l - 1;
//
//        for (int i = 0; i < q; i++){
//            while (curL < queries[i].l)
//                check(ID[curL++]);
//            while (curL > queries[i].l)
//                check(ID[--curL]);
//            while (curR < queries[i].r)
//                check(ID[++curR]);
//            while (curR > queries[i].r)
//                check(ID[curR--]);
//
//            int u = ID[curL], v = ID[curR];
//
//            if (queries[i].lc != u && queries[i].lc != v) check(queries[i].lc);
//
//            ans[queries[i].id] =res;
//
//            if (queries[i].lc != u && queries[i].lc != v) check(queries[i].lc);
//        }
    }

    void check(int x){
//        if  (!VIS[x]) {
//            for(int i=0;i<7;i++){
//                if(pow[x][i][0]==0)
//                    break;
//                res=mul(res,inv[ct[pow[x][i][0]]+1]);
//                ct[pow[x][i][0]]+=pow[x][i][1];
//                res=mul(res,ct[pow[x][i][0]]+1);
//            }
//        }
//        else{
//            for(int i=0;i<7;i++){
//                if(pow[x][i][0]==0)
//                    break;
//                res=mul(res,inv[ct[pow[x][i][0]]+1]);
//                ct[pow[x][i][0]]-=pow[x][i][1];
//                res=mul(res,ct[pow[x][i][0]]+1);
//            }
//        }
//        VIS[x] ^= true;
    }
}

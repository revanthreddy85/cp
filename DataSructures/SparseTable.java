package DataSructures;

public class SparseTable {
    int n,k;
    int [][]table;

    public SparseTable(int n) {
        this.n=n;
        k=findlog(n);
        table=new int[n][k+1];
    }

    public int findlog(int n){
        int ct=0;
        while (n>1){
            n>>=1;
            ct++;
        }
        return ct;
    }

    public int gcd(int a,int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }

    public int operation(int a,int b){
        return gcd(a,b);
    }

    public void build(int []arr){
        for(int i = 0; i < n; i++)
            table[i][0] = arr[i];
        for(int j = 1; j <= k; j++) {
            for(int i = 0; i <= n - (1 << j); i++)
                table[i][j] = operation(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
        }
    }
    public int get(int l,int r){
        int ans = 0;
        for(int j = k; j >= 0; j--) {
            if(l + (1 << j) - 1 <= r) {
                ans = operation(ans, table[l][j]);
                l += 1 << j;
            }
        }
        return ans;
//        int k=findlog(r-l+1);
//        return operation(table[l][k], table[r+1-(1<<k)][k]);
    }
}

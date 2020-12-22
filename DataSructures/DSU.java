package DataSructures;

public class DSU {
    public int []root;
    public int []size;

    public DSU (int n) {
        root=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<=n;i++) {
            root[i]=i;
            size[i]=1;
        }
    }


    public int find(int x) {
//        while(root[i]!=i) {
//            root[i]=root[root[i]];
//            i=root[i];
//        }
//        return i;
        if(x==root[x])
            return x;
        return root[x]=find(root[x]);
    }

    public void union (int x,int y) {
        int ra=find(x);
        int rb=find(y);
        if(ra==rb){
            return;
        }
        root[rb]=ra;
//        if(size[rb]<size[ra]){
//            root[rb]=ra;
//            size[ra]+=size[rb];
//        } else {
//            root[ra]=rb;
//            size[rb]+=size[ra];
//        }
    }

}

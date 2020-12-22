package DataSructures;

public class SegTree {

    public class Node{
        public int sum;
    }

    int n;
    Node []tree;

    public SegTree(int n) {
        this.n=n;
        tree=new Node[4*n];
        for(int i=1;i<4*n;i++)
            tree[i]=new Node();
    }

    Node treeOperation(Node a,Node b) {
        Node res=new Node();
        res.sum=a.sum+b.sum;
        return res;
    }

    public Node query(int node, int start, int end, int l, int r) {
        Node res=new Node();
        res.sum=0;
        if(r < start || end < l)
            return res;
        if(l <= start && end <= r)
            return tree[node];
        int mid = (start + end) / 2;
        Node left = query(2*node, start, mid, l, r);
        Node right = query(2*node+1, mid+1, end, l, r);
        return treeOperation(left , right);
    }

    public Node query(int l,int r) {
        return query(1,1,n,l,r);
    }

    public void update(int node, int start, int end, int pos, long val) {
        if(start == end) {
            tree[node].sum += val;
        }
        else
        {
            int mid = (start + end) / 2;
            if(pos <= mid)
                update(2*node, start, mid, pos, val);
            else
                update(2*node+1, mid+1, end, pos, val);
            tree[node] = treeOperation(tree[2*node] , tree[2*node+1]);
        }
    }

    public void update(int pos,long val) {
        update(1,1,n,pos,val);
    }
}


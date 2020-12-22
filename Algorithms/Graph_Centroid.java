package Algorithms;

import java.util.ArrayList;

public class Graph_Centroid {
    int n;
    public ArrayList<Integer>[]adj;
    public ArrayList <Integer> list;
    public int []sz;

    public Graph_Centroid(int n){
        this.n=n;
        list=new ArrayList<>();
        sz=new int[n+1];
        adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            adj[i]=new ArrayList<>();
    }

    public void dfs(int s,int p) {
        sz[s]=1;
        boolean flag=true;
        for (int c:adj[s]){
            if(c==p)
                continue;
            dfs(c,s);
            sz[s]+=sz[c];
            if(sz[c]>n/2)
                flag=false;
        }
        if(n-sz[s]>n/2)
            flag=false;
        if(flag)
            list.add(s);
    };
}

package com.demo1;

public class QuickFind {
    public int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i]=i;
    }

    public boolean connected(int q, int p){
        return id[p] == id[q];
    }

    public void unit (int p ,int q){
        int pid = id[p];
        for (int i = 0; i <id.length ; i++) {
            if(id[i]==pid){
                id[i]=id[q];
            }
        }
    }

}

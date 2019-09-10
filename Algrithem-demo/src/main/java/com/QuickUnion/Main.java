package com.QuickUnion;

public class Main {
    public static void main(String[] args) {
        QuickUnion qn = new QuickUnion(10);
        qn.union(4, 3);
        qn.union(3, 8);
        qn.union(6, 5);
        qn.union(9, 4);
        qn.union(2, 1);
        qn.connected(8, 9);
        qn.connected(5, 0);
        qn.union(5, 0);
        qn.union(7, 2);
        qn.union(6, 1);

        for (int i = 0; i < qn.id.length; i++) {
            System.out.println(qn.id[i]);
        }
    }
}

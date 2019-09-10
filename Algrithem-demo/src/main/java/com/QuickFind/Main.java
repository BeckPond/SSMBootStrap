package com.QuickFind;

public class Main {
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.unit(4, 3);
        qf.unit(3, 8);
        qf.unit(6, 5);
        qf.unit(9, 4);
        qf.unit(2, 1);
        qf.connected(8, 9);
        qf.connected(5, 0);
        qf.unit(5, 0);
        qf.unit(7, 2);
        qf.unit(6, 1);

        for (int i = 0; i < qf.id.length; i++) {
            System.out.println(qf.id[i]);
        }
    }
}

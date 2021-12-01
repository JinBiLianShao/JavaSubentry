package com.java;

public class hello {
    public static void main(String[] args) {
        int[] a = {2,5,3,9,12,7};
        int sum = f(a,0);
        System.out.println(sum);
    }
    private static int f(int[] a, int bagin) {
        if (bagin==a.length) {
            return 0;
        }
        int x = f(a,bagin+1);
        System.out.println("x:"+x+" bagin:"+bagin);
        return x + a[bagin];
    }

}

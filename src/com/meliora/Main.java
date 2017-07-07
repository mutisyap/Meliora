package com.meliora;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (int i=0; i<=1; i++){
            System.out.println("Printing "+i+" = "+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        }
    }
}

package com.meliora;

import java.util.LinkedList;
import java.util.Queue;

public class customers {
    int queueID;
    Queue<Integer> queue = new LinkedList<Integer>();

    public customers(int queueID){
        queueID = queueID;
    }

    public void addCustomer(int customerID){
        queue.add(customerID);
    }

    public void removeCustomer(){
        System.out.println(queue.remove());
    }
}

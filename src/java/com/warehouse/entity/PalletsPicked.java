/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

/**
 *
 * @author pawel_000
 */
public class PalletsPicked {
    private int id;
    private int workerID;
    private int clientID;
    private String products;
    
    public PalletsPicked(){
        
    }
    
    public PalletsPicked(int id, int workerID, int clientID, String products){
        this.id = id;
        this.workerID = workerID;
        this.clientID = clientID;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}

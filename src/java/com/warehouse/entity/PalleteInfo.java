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
public class PalleteInfo {
    private int id;
    private int amount;
    
    public PalleteInfo(){
        
    }
    
    public PalleteInfo(int id, int amount){
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pawel_000
 */

@Entity
@Table(name="pallets_to_send")
public class PalletsPacked implements Serializable{
    
    private int id;
    private int workerID;
    private int clientID;
    private String products;
    private String type;
    private Date date;
    
    public PalletsPacked(){
        
    }
    
    public PalletsPacked(int id, int workerID, int clientID, String products){
        this.id = id;
        this.workerID = workerID;
        this.clientID = clientID;
        this.products = products;
    }
    
    public PalletsPacked(int id, int workerID, int clientID, String products, Date date, String type){
        this.id = id;
        this.workerID = workerID;
        this.clientID = clientID;
        this.products = products;
        this.date = date;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="worker_id")
    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    @Column(name="client_id")
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
    
    @Column(name="whenMaked")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

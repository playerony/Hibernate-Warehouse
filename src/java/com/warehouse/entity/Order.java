/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pawel_000
 */
public class Order implements Serializable{
    private int id;
    private String items;
    private Date date;
    private Client client;
    
    public Order(){
        
    }
    
    public Order(int id, String items){
        this.id = id;
        this.items = items;
    }
    
    public Order(int id, String items, Date date){
        this.id = id;
        this.items = items;
        this.date = date;
    }
    
    public Order(int id, String items, Date date, Client client){
        this.id = id;
        this.items = items;
        this.date = date;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

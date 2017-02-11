/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author pawel_000
 */

@Entity
@Table(name="order_list")
public class Order implements Serializable{
    
    private int id;
    private String items;
    private Date date;
    private Client client;
    
    public Order(){
        
    }
    
    public Order(int id, String items, Date date, Client client){
        this.id = id;
        this.items = items;
        this.date = date;
        this.client = client;
    }

    @Id
    @GeneratedValue
    @Column(name="order_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="order_items")
    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Column(name="when_order")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JoinColumn(name="client_id") 
    @OneToOne(cascade = CascadeType.ALL)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

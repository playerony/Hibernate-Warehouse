/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;
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
@Table(name="pallets_in_magazine")
public class PalletsInMagazine implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String products;
    private String location;
    
    public PalletsInMagazine(){
        
    }
    
    public PalletsInMagazine(int id, String location){
        this.id = id;
        this.location = location;
    }
    
    public PalletsInMagazine(String products, String location){
        this.products = products;
        this.location = location;
    }
    
    public PalletsInMagazine(int id, String products, String location){
        this.id = id;
        this.products = products;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

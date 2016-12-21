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
public class PalletsInMagazine {
    private int id;
    private String products;
    private String location;
    
    public PalletsInMagazine(){
        
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
